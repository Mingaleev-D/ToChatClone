package com.example.tochatclone.ui.message

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tochatclone.data.local.UserHelper
import com.example.tochatclone.databinding.FragmentMessageBinding
import com.example.tochatclone.domain.ext.dpToPx
import com.example.tochatclone.domain.ext.hideKeyboard
import com.example.tochatclone.domain.model.Message
import com.example.tochatclone.util.Resource
import com.google.firebase.Timestamp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageFragment : Fragment() {

   private var mBinding: FragmentMessageBinding? = null
   private val binding: FragmentMessageBinding get() = mBinding!!

   private val args: MessageFragmentArgs by navArgs()
   private val viewModel: MessageViewModel by viewModels()

   private val messagesListAdapter by lazy {
      MessagesListAdapter(args.userId)
   }

   override fun onAttach(context: Context) {
      super.onAttach(context)
      (requireActivity() as AppCompatActivity).supportActionBar?.hide()
   }

   override fun onDetach() {
      super.onDetach()
      (requireActivity() as AppCompatActivity).supportActionBar?.show()
   }

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentMessageBinding.inflate(inflater, container, false)
      return binding.root
   }


   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      setupRecyclerView()
      subscribeViewModel()
      setupMessageListener()
      setupUserInformation()
      setupClickListener()
   }

   private fun setupRecyclerView() {
      binding.messageList.apply {
         adapter = messagesListAdapter
         addItemDecoration(VerticalMarginItemDecoration(requireContext().dpToPx(8)))
      }
   }

   private fun setupClickListener() {
      binding.backButton.setOnClickListener { activity?.onBackPressed() }
      binding.bSendMessage.setOnClickListener { handleSendMessage() }
   }

   private fun setupUserInformation() {

      val userToText = UserHelper.userList.find {
         it.id == args.messageId
      } ?: throw Exception("Invalid id")

      with(binding) {
         chatImage.setImageResource(userToText.image)
         chatName.text = userToText.name
      }
   }

   private fun setupMessageListener() {
      with(binding) {
         etMessage.addTextChangedListener {
            llSendMessage.isVisible = it.toString().isNotEmpty()
         }
         etMessage.setOnEditorActionListener { textView, actionId, keyEvent ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
               handleSendMessage()
            }
            true
         }
      }
   }
   private fun subscribeViewModel() {
      viewModel.messagesListState.observe(viewLifecycleOwner) { state ->
         when(state) {
            is Resource.Success -> {
               handleMessages(messages = state.data)
            }
            is Resource.Error -> {
               Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
            }
            is Resource.Loading -> {
               handleLoading(isLoading = true)
            }
            else -> Unit
         }
      }

      viewModel.sendMessageState.observe(viewLifecycleOwner) { state ->
         when(state) {
            is Resource.Success -> clearMessage()
            is Resource.Error -> clearMessage()
            else -> Unit
         }
      }
   }

   private fun handleSendMessage() {
      viewModel.sendMessage(
         Message(
            chatId = args.userId,
            message = binding.etMessage.text.toString(),
            senderId = args.userId,
            timestamp = Timestamp.now()
         )
      )
   }

   private fun handleLoading(isLoading: Boolean) {
      with(binding) {
         pbMessages.isVisible = isLoading
      }
   }

   private fun handleMessages(messages: List<Message>) {
      if (messages.isEmpty()) {
         showEmptyScreen()
      } else {
         messagesListAdapter.submitList(messages)
         showMessages()
      }
   }
   private fun showEmptyScreen() {
      handleLoading(isLoading = false)
      with(binding) {
         messageList.isVisible = false
         tvEmptyMessages.isVisible = true
      }
   }

   private fun showMessages() {
      handleLoading(isLoading = false)
      with(binding) {
         tvEmptyMessages.isVisible = false
         messageList.isVisible = true
      }
   }

      private fun clearMessage() {
      binding.etMessage.text.clear()
      binding.messageList.smoothScrollToPosition(0)
   }

}