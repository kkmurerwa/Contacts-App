package com.example.mycontacts.Fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
//import androidx.navigation.fragment.findNavController
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

        setHasOptionsMenu(true)
        return view

    }
    private fun Updates(){
        val name =updateContactName.text.toString()
        val email=updateEmailAdress.text.toString()
        val number=Integer.parseInt(updatePhoneNumber.text.toString())

        if(checkDetails(name,email,number = updatePhoneNumber.text as Editable)){

            val newContactUpdate = Contact(args.currentContact.id,name, email, number)

            myContactViewModel.updateContact(newContactUpdate)

            Toast.makeText(requireContext(),"Contact Update Successfully", Toast.LENGTH_SHORT).show()


     //       findNavController().navigate(R.id.action_updateFragment_to_contactsFragment)
        }else{
            Toast.makeText(requireContext(),"Fill the details to update contact", Toast.LENGTH_SHORT).show()
        }
    }
    private fun checkDetails(name:String,email:String,number: Editable):Boolean{
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && number.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val alert= AlertDialog.Builder(requireContext())
        alert.setPositiveButton("Yes"){_,_->

            myContactViewModel.deleteContact(args.currentContact)
            Toast.makeText(requireContext(),"Successfully deleted: ${args.currentContact.name}",Toast.LENGTH_SHORT).show()

        findNavController().navigate(R.id.action_updateFragment_to_contactsFragment)

        }
        alert.setNegativeButton("No"){_,_->}
        alert.setTitle("Delete ${args.currentContact.name}?")
        alert.setMessage("Are you sure you want to delete ${args.currentContact.name}?")
        alert.create().show()

    }

}