package com.example.tochatclone.ui.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tochatclone.databinding.FragmentCallsBinding


class CallsFragment : Fragment() {

   private var mBinding: FragmentCallsBinding? = null
   private val binding: FragmentCallsBinding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentCallsBinding.inflate(inflater, container, false)
      return binding.root
   }

}