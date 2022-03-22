package com.example.roomlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomlist.data.User
import com.example.roomlist.data.UserViewModel


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_add, container, false)
        val  genderList :  List<String> = listOf("Gender..","Male","Female")
        val items= resources.getStringArray(R.array.genderArray)

        val  buttonView : Button =   view.findViewById(R.id.buttonView);
        val  buttonSubmit : Button =   view.findViewById(R.id.buttonSubmit);
        val  firstNameET : EditText = view.findViewById(R.id.firstNameET);
        val  middleNameET : EditText =  view.findViewById(R.id.lastNameET);
        val  lastNameET : EditText =  view.findViewById(R.id.middleNameET);
        val  fatherNameET : EditText =  view.findViewById(R.id.fatherNameET);

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        buttonSubmit.setOnClickListener{
           val firstName = firstNameET.text.toString()
           val middleName = middleNameET.text.toString()
           val lastName = lastNameET.text.toString()
           val fatherName = fatherNameET.text.toString()

            if (firstName.isEmpty()){
                firstNameET.error = "First Name Required"
                firstNameET.requestFocus()
                return@setOnClickListener
            }

            if (middleName.isEmpty()){
                middleNameET.error = "Middle Name Required"
                middleNameET.requestFocus()
                return@setOnClickListener
            }
            if (lastName.isEmpty()){
                lastNameET.error = "Last Name Required"
                lastNameET.requestFocus()
                return@setOnClickListener
            }

            if (fatherName.isEmpty()){
                fatherNameET.error = "Father Name Required"
                fatherNameET.requestFocus()
                return@setOnClickListener
            }

            val user = User(0,firstName,lastName,middleName,fatherName)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully added!", LENGTH_LONG).show()
        }

        buttonView.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return view



    }



}