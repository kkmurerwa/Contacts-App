package com.example.mycontacts.Fragments.contacts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycontacts.R
import com.example.mycontacts.data.ContactViewModel
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

        return view

    }
}