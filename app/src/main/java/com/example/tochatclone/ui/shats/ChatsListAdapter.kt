package com.example.tochatclone.ui.shats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.tochatclone.databinding.ItemChatBinding
import com.example.tochatclone.domain.model.Chats
import com.example.tochatclone.ui.common.BaseListViewHolder

/**
 * @author : Mingaleev D
 * @data : 15/11/2022
 */

class ChatsListAdapter(
   private val onChatsClick: (Chats) -> Unit,
) : ListAdapter<Chats, BaseListViewHolder<*>>(DiffUtilCallback) {

   private object DiffUtilCallback : DiffUtil.ItemCallback<Chats>() {
      override fun areItemsTheSame(oldItem: Chats, newItem: Chats): Boolean =
         oldItem.id == newItem.id

      override fun areContentsTheSame(oldItem: Chats, newItem: Chats): Boolean = oldItem == newItem
   }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
      val itemBinding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
      return BindViewHolder(itemBinding)
   }

   override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
      when (holder) {
         is BindViewHolder -> holder.bind(getItem(position), position)
      }
   }

   inner class BindViewHolder(private val binding: ItemChatBinding) :
      BaseListViewHolder<Chats>(binding.root) {

      override fun bind(item: Chats, position: Int) = with(binding) {

         chatName.text = item.chatName
         chatImage.setImageResource(item.chatImage)

         chatParent.setOnClickListener { onChatsClick.invoke(item) }
      }
   }
}