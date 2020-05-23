package com.yasintanriverdi.core.data

sealed class DataState {
    object Success : DataState()
    object Loading : DataState()
    data class Error(val message: String) : DataState()

    fun isLoading() = this is Loading

    fun isError() = this is Error
}