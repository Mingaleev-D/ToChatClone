package com.example.tochatclone.ui.message

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

class VerticalMarginItemDecoration(private val spaceSize: Int) : RecyclerView.ItemDecoration() {
   override fun getItemOffsets(
      outRect: Rect, view: View,
      parent: RecyclerView,
      state: RecyclerView.State
   ) {
      with(outRect) {
         //if (parent.getChildAdapterPosition(view) == 0) {

         //}
         top = spaceSize
         //left = spaceSize
         //right = spaceSize
         //bottom = spaceSize
      }
   }
}