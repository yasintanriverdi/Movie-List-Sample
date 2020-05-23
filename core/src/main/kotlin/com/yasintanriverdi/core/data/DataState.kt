package com.yasintanriverdi.core.data

sealed class DataState {
    data class Success(val isEmpty: Boolean = false, val hasMore: Boolean = false) : DataState()
    object Loading : DataState()
    data class Error(val message: String) : DataState()

    fun isLoading() = this is Loading

    fun isError() = this is Error
}