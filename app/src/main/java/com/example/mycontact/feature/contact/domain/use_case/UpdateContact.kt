package com.example.mycontact.feature.contact.domain.use_case

import com.example.mycontact.feature.contact.domain.ContactRepository
import com.example.mycontact.feature.contact.domain.model.Contact
import javax.inject.Inject

class UpdateContact @Inject constructor(
    private val repository: ContactRepository,
) {
    suspend operator fun invoke(contact: Contact) =
        repository.updateContact(contact)
}