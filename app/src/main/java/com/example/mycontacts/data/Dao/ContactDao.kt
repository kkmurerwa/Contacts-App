package com.example.mycontacts.data.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mycontacts.data.Entity.Contact

@Dao
interface ContactDao {

    @Insert
    suspend fun addContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("SELECT * FROM contacts_table ORDER BY id ASC")
    fun readAllData():LiveData<List<Contact>>
}