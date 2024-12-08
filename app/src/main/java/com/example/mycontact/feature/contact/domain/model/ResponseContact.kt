package com.example.mycontact.feature.contact.domain.model

interface ResponseContact<out T> {

    data object Loading : ResponseContact<Nothing>
    data class Success<out T>(val data : T) : ResponseContact<T>
    data class Error (val error: Throwable) : ResponseContact<Nothing>

}