package com.example.mycontact.feature.contact.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mycontact.feature.contact.domain.model.Contact


@Database(entities = [Contact::class], version = 1, exportSchema = true)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao
}