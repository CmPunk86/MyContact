package com.example.mycontact.feature.contact.domain

import com.example.mycontact.feature.contact.domain.model.Contact
import kotlinx.coroutines.flow.Flow


interface ContactRepository {

    fun getAllContact() : Flow<List<Contact>>

    suspend fun insertContact(contact: Contact)

    suspend fun deleteContact(contact: Contact)

    suspend fun updateContact(contact: Contact)
}