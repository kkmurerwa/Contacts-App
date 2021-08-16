package com.example.mycontacts.Fragments.Add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.data.Entity.Contact
import com.example.mycontacts.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var myContactViewModel: ContactViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)

        myContactViewModel =ViewModelProvider(this).get(ContactViewModel::class.java)

    view.savebutton.setOnClickListener{
        insertData()

    }

        return view
    }

    private fun insertData() {
        val name =ContactName.text.toString()
        val email=EmailAdress.text.toString()
        val number=PhoneNumber.text

        if(checkDetails(name,email, number as Editable)){
            val contact = Contact(0,name,email,Integer.parseInt(number.toString()))

            myContactViewModel.addContact(contact)
            Toast.makeText(requireContext(),"Contact Saved Successfully",Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_contactsFragment)
        }else{
            Toast.makeText(requireContext(),"Fill All Details",Toast.LENGTH_LONG).show()
        }


    }

    private fun checkDetails(name:String,email:String,number:Editable):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && number.isEmpty())
    }

}