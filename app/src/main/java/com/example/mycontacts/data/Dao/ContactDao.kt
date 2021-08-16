package com.example.mycontacts.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mycontacts.data.Entity.Contact

@Dao
interface ContactDao {

    @Insert
    suspend fun addContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("DELETE FROM contacts_table")
    suspend fun deleteAllContacts()

    @Query("SELECT * FROM contacts_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Contact>>
}