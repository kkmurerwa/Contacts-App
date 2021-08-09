package com.example.mycontacts.data.Dao

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface ContactDao {

    @Insert(onConflict = onConflictStrategy.IGNORE)
    suspend fun addContact(contact: Contact)


}