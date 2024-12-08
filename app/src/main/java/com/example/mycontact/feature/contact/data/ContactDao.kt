package com.example.mycontact.feature.contact.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mycontact.feature.contact.domain.model.Contact
import kotlinx.coroutines.flow.Flow


@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts ORDER BY id ASC")
    fun getAllContact() : Flow<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateContact(contact: Contact)



}