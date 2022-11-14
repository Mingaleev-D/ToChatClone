package com.example.tochatclone.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tochatclone.ui.calls.CallsFragment
import com.example.tochatclone.ui.shats.ChatsFragment
import com.example.tochatclone.ui.social.SocialFragment

/**
 * @author : Mingaleev D
 * @data : 15/11/2022
 */

class DashPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
   override fun getItemCount(): Int = 3

   override fun createFragment(position: Int): Fragment {
      return when (position) {
         0 -> {
            ChatsFragment()
         }
         1 -> {
            SocialFragment()
         }
         2 -> {
            CallsFragment()
         }
         else -> throw IllegalArgumentException("Invalid fragment position, mac value 2")
      }
   }
}