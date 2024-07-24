package com.example.adressbook

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val firstNameDetail: TextView = findViewById(R.id.first_name_detail)
        val lastNameDetail: TextView = findViewById(R.id.last_name_detail)
        val addressDetail: TextView = findViewById(R.id.address_detail)
        val phoneDetail: TextView = findViewById(R.id.phone_detail)

        val person = intent.getParcelableExtra<Person>("person")

        person?.let {
            firstNameDetail.text = "Имя: ${it.firstName}"
            lastNameDetail.text = "Фамилия: ${it.lastName}"
            addressDetail.text = "Адрес: ${it.address}"
            phoneDetail.text = "Телефон: ${it.phone}"
        }
    }
}
