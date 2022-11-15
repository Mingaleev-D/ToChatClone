package com.example.tochatclone.ui.message

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tochatclone.data.local.UserHelper
import com.example.tochatclone.databinding.FragmentMessageBinding
import com.example.tochatclone.domain.ext.hideKeyboard


class MessageFragment : Fragment() {

   private var mBinding: FragmentMessageBinding? = null
   private val binding: FragmentMessageBinding get() = mBinding!!

   private val args:MessageFragmentArgs by navArgs()

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
      setupMessageListener()
      setupUserInformation()
      setupClickListener()
   }

   private fun setupClickListener() {
      binding.backButton.setOnClickListener { activity?.onBackPressed() }
   }

   private fun setupUserInformation() {

      val userToText = UserHelper.userList.find {
         it.id == args.messageId
      } ?: throw Exception("Invalid id")

      with(binding){
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
              hideKeyboard()
            }
            true
         }
      }
   }

}