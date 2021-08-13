package com.example.mycontacts.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycontacts.R
import com.example.mycontacts.data.ContactViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var myContactViewModel:ContactViewModel
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
        TODO("Not yet implemented")
    }
}