package com.example.tochatclone.ui.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tochatclone.data.local.UserHelper
import com.example.tochatclone.databinding.FragmentUserSelectionBinding


class UserSelectionFragment : Fragment() {

   private var mBinding: FragmentUserSelectionBinding? = null
   private val binding: FragmentUserSelectionBinding get() = mBinding!!

   private val userListAdapter = UserListAdapter(){
      val action = UserSelectionFragmentDirections.actionUserSelectionFragmentToDashBoardFragment(userId = it.id)
      findNavController().navigate(action)
   }

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentUserSelectionBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      setupRecyclerView()
   }

   private fun setupRecyclerView() {
      binding.userList.apply {
         adapter = userListAdapter
         layoutManager = GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
      }
      userListAdapter.submitList(UserHelper.userList)
   }

}