package com.example.mycontacts.Fragments.update

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
import androidx.navigation.fragment.navArgs
import com.example.mycontacts.R
import com.example.mycontacts.data.Entity.Contact
import com.example.mycontacts.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var myContactViewModel: ContactViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_update, container, false)

        myContactViewModel =ViewModelProvider(this).get(ContactViewModel::class.java)

        view.updateContactName.setText(args.currentContact.name)
        view.updateEmailAdress.setText(args.currentContact.email)
        view.updatePhoneNumber.setText(args.currentContact.number.toString())

        view.updatenewbutton.setOnClickListener{
            Updates()
        }

        return view

    }
    private fun Updates(){
        val name =updateContactName.text.toString()
        val email=updateEmailAdress.text.toString()
        val number=Integer.parseInt(updatePhoneNumber.text.toString())

        if(checkDetails(name,email,updatePhoneNumber.text)){

            val newContactUpdate = Contact(args.currentContact.id,name, email, number)

            myContactViewModel.updateContact(newContactUpdate)

            Toast.makeText(requireContext(),"Contact Update Successfully", Toast.LENGTH_SHORT).show()


            findNavController().navigate(R.id.action_updateFragment_to_contactsFragment)
        }else{
            Toast.makeText(requireContext(),"Fill the details to update contact", Toast.LENGTH_SHORT).show()
        }
    }
    private fun checkDetails(name:String,email:String,number: Editable):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && number.isEmpty())
    }


}