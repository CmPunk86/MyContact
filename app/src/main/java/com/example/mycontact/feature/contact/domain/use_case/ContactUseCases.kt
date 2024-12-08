package com.example.mycontact.feature.contact.domain.use_case

data class ContactUseCases (
    val insertContact: InsertContact,
    val deleteContact: DeleteContact,
    val updateContact: UpdateContact,
    val getAllContact: GetAllContact
)