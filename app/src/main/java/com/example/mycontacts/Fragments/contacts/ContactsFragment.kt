package com.example.mycontacts.Fragments.contacts

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontacts.R
import com.example.mycontacts.viewmodel.ContactViewModel
import kotlinx.android.synthetic.main.fragment_contacts.view.*


class ContactsFragment : Fragment() {

    private lateinit var myContactViewModel: ContactViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view= inflater.inflate(R.layout.fragment_contacts, container, false)

        val adapter=ContactsAdapter()
        val recyclerView=view.recyclerview
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())

        myContactViewModel =ViewModelProvider(this).get(ContactViewModel::class.java)
        myContactViewModel.readAllData.observe(viewLifecycleOwner, Observer { contact ->
            adapter.setDetails(contact)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_contactsFragment_to_addFragment)
        }


        setHasOptionsMenu(true)


        return view

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId ==R.id.delete) {
            deleteAllContacts()
        }
    return super.onOptionsItemSelected(item)

    }

    private fun deleteAllContacts() {
        val alert= AlertDialog.Builder(requireContext())
        alert.setPositiveButton("Yes"){_,_->

            myContactViewModel.deleteAllContacts()
            Toast.makeText(requireContext(),"Successfully All Contacts", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_updateFragment_to_contactsFragment)

        }
        alert.setNegativeButton("No"){_,_->}
        alert.setTitle("Delete All Contacts")
        alert.setMessage("Are you sure you want to delete all Contacts?")
        alert.create().show()
    }

}