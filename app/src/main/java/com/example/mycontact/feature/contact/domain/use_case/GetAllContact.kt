package com.example.mycontact.feature.contact.domain.use_case

import com.example.mycontact.feature.contact.domain.ContactRepository
import com.example.mycontact.feature.contact.domain.model.Contact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllContact @Inject constructor(
    private val repository: ContactRepository,
) {

    operator fun invoke() : Flow<List<Contact>> {
        return repository.getAllContact()
    }
}