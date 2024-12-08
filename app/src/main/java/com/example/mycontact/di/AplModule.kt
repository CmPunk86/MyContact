package com.example.mycontact.di

import android.content.Context
import androidx.room.Room
import com.example.mycontact.feature.contact.data.ContactDatabase
import com.example.mycontact.feature.contact.data.ContactRepositoryImpl
import com.example.mycontact.feature.contact.domain.ContactRepository
import com.example.mycontact.feature.contact.domain.use_case.ContactUseCases
import com.example.mycontact.feature.contact.domain.use_case.DeleteContact
import com.example.mycontact.feature.contact.domain.use_case.GetAllContact
import com.example.mycontact.feature.contact.domain.use_case.InsertContact
import com.example.mycontact.feature.contact.domain.use_case.UpdateContact
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AplModule {

    @Provides
    @Singleton
    fun provideContactDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ContactDatabase::class.java,
            "contact_database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideContactRepository(db : ContactDatabase) : ContactRepository {
        return ContactRepositoryImpl(dao = db.contactDao())
    }

    @Provides
    @Singleton
    fun provideContactUseCases(repository: ContactRepository) : ContactUseCases {
        return ContactUseCases(
            insertContact = InsertContact(repository),
            updateContact = UpdateContact(repository),
            deleteContact = DeleteContact(repository),
            getAllContact = GetAllContact(repository)
        )
    }

}