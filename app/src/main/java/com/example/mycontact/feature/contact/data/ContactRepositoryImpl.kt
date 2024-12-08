package com.example.mycontact.feature.contact.data

import com.example.mycontact.feature.contact.domain.model.Contact
import com.example.mycontact.feature.contact.domain.ContactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val dao: ContactDao,
) : ContactRepository {
    override fun getAllContact(): Flow<List<Contact>> {
        return dao.getAllContact()
    }

    override suspend fun insertContact(contact: Contact) =
        dao.insertContact(contact)


    override suspend fun deleteContact(contact: Contact) =
        dao.deleteContact(contact)

    override suspend fun updateContact(contact: Contact) =
        dao.updateContact(contact)
}