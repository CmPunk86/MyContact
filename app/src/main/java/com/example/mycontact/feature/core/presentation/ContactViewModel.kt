package com.example.mycontact.feature.core.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycontact.feature.contact.domain.model.Contact
import com.example.mycontact.feature.contact.domain.model.ResponseContact
import com.example.mycontact.feature.contact.domain.use_case.ContactUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ContactViewModel @Inject constructor(
    private val useCases: ContactUseCases
) : ViewModel() {
    var contact by mutableStateOf(Contact(0, "", "")
    )

    private var deleteContact: Contact? = null
    private val _response = MutableStateFlow<ResponseContact<List<Contact>>>(ResponseContact.Loading)

    val response = _response.asStateFlow()
    private fun getAllContact() = viewModelScope.launch {
        useCases.getAllContact()
            .onStart {
                _response.value = ResponseContact.Loading
            }.catch {
                _response.value = ResponseContact.Error(it)
            }.collect {
                _response.value = ResponseContact.Success(it)
            }
    }

    fun insertContact(contact: Contact) {
        viewModelScope.launch {
            useCases.insertContact(contact = contact)
        }
    }

    fun updateContact(contact: Contact) {
        viewModelScope.launch {
            useCases.updateContact(contact = contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch {
            deleteContact = contact
            useCases.deleteContact(contact = contact)
        }
    }


}