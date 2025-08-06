package com.example.fakestore.util

sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T): ResultWrapper<T>()
    data class Error(val message: String): ResultWrapper<Nothing>()
    object Loading: ResultWrapper<Nothing>()
}
