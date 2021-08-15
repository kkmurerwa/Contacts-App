package com.example.mycontacts.data.Entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "contacts_table")
data class Contact(
    @PrimaryKey(autoGenerate =true)
    val id:Int,
    val name:String,
    val email:String,
    val number:Int
):Parcelable