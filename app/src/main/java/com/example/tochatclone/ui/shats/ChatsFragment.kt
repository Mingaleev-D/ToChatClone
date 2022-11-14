package com.example.tochatclone.ui.shats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tochatclone.databinding.FragmentChatsBinding


class ChatsFragment : Fragment() {

   private var mBinding: FragmentChatsBinding? = null
   private val binding: FragmentChatsBinding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentChatsBinding.inflate(inflater, container, false)
      return binding.root
   }


}