package com.example.mycontacts.data.Dao




@Dao
interface ContactDao{

    @Insert(onConflict= androidx.room.OnConflictStrategy.IGNORE)
    suspend fun addContact(contact:Contact)



}