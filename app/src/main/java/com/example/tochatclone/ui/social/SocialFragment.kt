package com.example.tochatclone.ui.social

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tochatclone.databinding.FragmentSocialBinding


class SocialFragment : Fragment() {

   private var mBinding: FragmentSocialBinding? = null
   private val binding: FragmentSocialBinding get() = mBinding!!

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentSocialBinding.inflate(inflater, container, false)
      return binding.root
   }


}