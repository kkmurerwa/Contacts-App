package com.example.mycontacts.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mycontacts.data.Entity.Contact
import com.example.mycontacts.data.database.ContactDatabase
import com.example.mycontacts.data.repository.ContactRepository
import kotlinx.coroutines.launch

class ContactViewModel(application: Application):AndroidViewModel(application) {

    private val readAllData: LiveData<List<Contact>>
    private val repository:ContactRepository


    init {
        val contactDao = ContactDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        readAllData = repository.readAllData
    }

    fun addContact(contact: Contact){
        viewModelScope.launch {
            repository.addContact(contact)
        }
    }
}