package com.yasintanriverdi.core.data

sealed class UIState {
    object Content : UIState()
    object Loading : UIState()
    data class Error(val message: String) : UIState()

    fun isLoading() = this is Loading

    fun isError() = this is Error
}