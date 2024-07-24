package com.example.adressbook

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val personList = mutableListOf<Person>()
    private lateinit var personListView: ListView
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var addressEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameEditText = findViewById(R.id.first_name)
        lastNameEditText = findViewById(R.id.last_name)
        addressEditText = findViewById(R.id.address)
        phoneEditText = findViewById(R.id.phone)
        saveButton = findViewById(R.id.save_button)
        personListView = findViewById(R.id.person_list)

        val adapter = ArrayAdapter<Person>(
            this,
            android.R.layout.simple_list_item_1,
            personList
        )

        personListView.adapter = adapter

        saveButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val address = addressEditText.text.toString()
            val phone = phoneEditText.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty()) {
                val person = Person(firstName, lastName, address, phone)
                personList.add(person)
                adapter.notifyDataSetChanged()
                clearFields()
            }
        }

        personListView.setOnItemClickListener { _, _, position, _ ->
            val selectedPerson = personList[position]
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("person", selectedPerson)
            }
            startActivity(intent)
        }
    }

    private fun clearFields() {
        firstNameEditText.text.clear()
        lastNameEditText.text.clear()
        addressEditText.text.clear()
        phoneEditText.text.clear()
    }
}
