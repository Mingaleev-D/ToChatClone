package com.example.tochatclone.data.local

import com.example.tochatclone.R
import com.example.tochatclone.domain.model.Chats
import com.example.tochatclone.domain.model.User

object UserHelper {
   val userList = listOf(
      User(
         id = "1",
         image = R.drawable.girl,
         name = "Mary"
      ),
      User(
         id = "2",
         image = R.drawable.boy,
         name = "Bobbi"
      ),
      User(
         id = "3",
         image = R.drawable.men,
         name = "Gal"
      ),  User(
         id = "4",
         image = R.drawable.naruto,
         name = "Naruto"
      )
   )

   val chatsList = listOf(
      Chats(
         id = "1",
         chatImage = R.drawable.girl,
         chatName = "Mary"
      ),
      Chats(
         id = "2",
         chatImage = R.drawable.boy,
         chatName = "Bobbi"
      ),
      Chats(
         id = "3",
         chatImage = R.drawable.men,
         chatName = "Gal"
      ),
      Chats(
         id = "4",
         chatImage = R.drawable.naruto,
         chatName = "Naruto"
      )
   )
}