package com.example.tochatclone.domain.model

import androidx.annotation.DrawableRes

data class Chats(
   @DrawableRes val chatImage: Int,
   val chatName: String,
   val id: String
)
