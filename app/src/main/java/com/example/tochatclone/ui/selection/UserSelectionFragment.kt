package com.example.tochatclone.ui.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tochatclone.databinding.FragmentUserSelectionBinding


class UserSelectionFragment : Fragment() {

   private var mBinding: FragmentUserSelectionBinding? = null
   private val binding: FragmentUserSelectionBinding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentUserSelectionBinding.inflate(inflater, container, false)
      return binding.root
   }

}