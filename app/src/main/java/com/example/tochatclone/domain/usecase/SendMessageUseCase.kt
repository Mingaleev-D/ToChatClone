package com.example.tochatclone.domain.usecase

import com.example.tochatclone.data.remote.Constants.DEFAULT_NETWORK_ERROR
import com.example.tochatclone.domain.model.Message
import com.example.tochatclone.domain.repository.MessageRepository
import com.example.tochatclone.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

class SendMessageUseCase @Inject constructor(
   private val repository: MessageRepository,
) {
   suspend operator fun invoke(message: Message): Flow<Resource<Unit>> = flow {

      emit(Resource.Loading)

      val networkRequest = repository.sendMessage(message = message)

      when (networkRequest) {
         is Resource.Success -> emit(Resource.Success(Unit))
         is Resource.Error -> emit(Resource.Error(networkRequest.message))
         else -> emit(Resource.Error(DEFAULT_NETWORK_ERROR))
      }

   }
}