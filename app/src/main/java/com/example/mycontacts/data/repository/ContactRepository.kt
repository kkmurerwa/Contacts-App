package com.example.mycontacts.data.repository

import androidx.lifecycle.LiveData
import com.example.mycontacts.data.Dao.ContactDao
import com.example.mycontacts.data.Entity.Contact

class ContactRepository(private val contactDao: ContactDao) {
    val readAllData: LiveData<List<Contact>> =ContactDao.readAllData()

    suspend fun addContact(contact:Contact){
        contactDao.addContact(contact)
    }

    suspend fun updateContact(contact: Contact){
        contactDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: Contact){
        contactDao.deleteContact(contact)
    }

    suspend fun deleteAllContacts(){
        contactDao.deleteAllContacts()
    }
    ]



}