package com.example.tochatclone.domain.repository

import com.example.tochatclone.domain.model.Message
import com.example.tochatclone.util.Resource

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

interface MessageRepository {

   suspend fun sendMessage(message:Message):Resource<Unit>

  // suspend fun fetchMessagesByChat(chatId:String):Resource<List<Message>>
}