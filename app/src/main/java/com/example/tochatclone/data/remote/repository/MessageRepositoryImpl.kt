package com.example.tochatclone.data.remote.repository

import com.example.tochatclone.data.remote.Constants.DEFAULT_NETWORK_ERROR
import com.example.tochatclone.domain.model.Message
import com.example.tochatclone.domain.repository.MessageRepository
import com.example.tochatclone.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

class MessageRepositoryImpl @Inject constructor(
private val firestore:FirebaseFirestore
) :MessageRepository {

   override suspend fun sendMessage(message:Message): Resource<Unit> {
      return try {
         var isSuccessful = false
         firestore.collection(message.chatId)
            .document(message.id)
            .set(message, SetOptions.merge())
            .addOnCompleteListener { isSuccessful = it.isSuccessful }
            .await()

         if (isSuccessful) {
            Resource.Success(Unit)
         } else {
            Resource.Error(DEFAULT_NETWORK_ERROR)
         }
      } catch (e: Exception) {
         Resource.Error(e.message.toString())

      }
   }

//   override suspend fun fetchMessagesByChat(chatId: String): Resource<List<Message>> {
//      TODO("Not yet implemented")
//   }
}