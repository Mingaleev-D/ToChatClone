package com.example.tochatclone.di

import com.example.tochatclone.data.remote.repository.MessageRepositoryImpl
import com.example.tochatclone.domain.repository.MessageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

   @Binds
   abstract fun bindMessagesRepository(
      messagesRepository: MessageRepositoryImpl
   ): MessageRepository

}