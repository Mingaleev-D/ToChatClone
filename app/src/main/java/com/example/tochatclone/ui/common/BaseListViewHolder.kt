package com.example.tochatclone.ui.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : Mingaleev D
 * @data : 15/11/2022
 */

abstract class BaseListViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
   abstract fun bind(item: T, position: Int)
}