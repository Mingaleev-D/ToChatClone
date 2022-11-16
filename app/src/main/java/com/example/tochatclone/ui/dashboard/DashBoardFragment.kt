package com.example.tochatclone.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tochatclone.R
import com.example.tochatclone.databinding.FragmentDashBoardBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashBoardFragment : Fragment() {

   private var mBinding: FragmentDashBoardBinding? = null
   private val binding: FragmentDashBoardBinding get() = mBinding!!

   private val args:DashBoardFragmentArgs by navArgs()

   override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View {
      mBinding = FragmentDashBoardBinding.inflate(inflater, container, false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      setupViewpager()
   }

   private fun setupViewpager() {
      binding.dashViewPager.apply {
         adapter = DashPagerAdapter(this@DashBoardFragment,userId = args.userId)
      }
      TabLayoutMediator(binding.dashboardTabLayout, binding.dashViewPager) { tab, position ->
         tab.text = when(position) {
            0 ->getString(R.string.chats)
            1 ->getString(R.string.social)
            2 ->getString(R.string.calls)
            else -> throw Exception("Invalid positions")
         }
      }.attach()
   }


}