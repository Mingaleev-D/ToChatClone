package com.example.tochatclone.util

/**
 * @author : Mingaleev D
 * @data : 16/11/2022
 */

sealed class Resource <out R> {
   data class Success<out T>(val data: T): Resource<T>()
   data class Error(val message: String): Resource<Nothing>()
   object Loading : Resource<Nothing>()
}