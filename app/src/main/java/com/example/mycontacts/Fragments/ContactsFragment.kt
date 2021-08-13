package com.example.mycontacts.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import kotlinx.android.synthetic.main.fragment_contacts.view.*


class ContactsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view= inflater.inflate(R.layout.fragment_contacts, container, false)


        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_contactsFragment_to_addFragment)
        }

        return view

    }
}