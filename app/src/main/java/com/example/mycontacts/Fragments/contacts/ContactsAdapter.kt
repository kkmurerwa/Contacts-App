package com.example.mycontacts.Fragments.contacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.R
import com.example.mycontacts.data.Entity.Contact
import kotlinx.android.synthetic.main.my_rows.view.*

class ContactsAdapter: RecyclerView.Adapter<ContactsAdapter.MyViewHolder>() {

    private var contactList= emptyList<Contact>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.my_rows,parent,false))
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentData=contactList[position]
        holder.itemView.textView_number.text=currentData.id.toString()
        holder.itemView.contactsaved_as.text=currentData.name
        holder.itemView.save_email_address.text=currentData.email
        holder.itemView.save_contact_as.text=currentData.number.toString()
    }

    fun setDetails(contact: List<Contact>){
        this.contactList=contact
        notifyDataSetChanged()
    }

}