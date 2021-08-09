package com.example.mycontacts.data.repository

import com.example.mycontacts.data.Entity.Contact

class ContactRepository(private val contactDao:ContactDao) {
    val readAllData:LiveData<List<Contact>> =ContactDao.readAllData()

    suspend fun addContact(contact:Contact){
        contactDao.addContact(contact)
    }
}