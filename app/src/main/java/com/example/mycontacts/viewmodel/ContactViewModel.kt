package com.example.mycontacts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mycontacts.data.Entity.Contact
import com.example.mycontacts.data.database.ContactDatabase
import com.example.mycontacts.data.repository.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<Contact>>
    private val repository:ContactRepository


    init {
        val contactDao = ContactDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        readAllData = repository.readAllData
    }

    fun addContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addContact(contact)
        }
    }
    fun updateContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateContact(contact)
        }
    }

    fun deleteContact(contact: Contact){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteContact(contact)
        }
    }

    fun deleteAllContacts(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllContacts()
        }
    }

}