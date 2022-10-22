package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ParcelabelActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelabel)

        val tvObject: TextView = findViewById(R.id.tv_data_received_parcelabel)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val text =
            "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
        tvObject.text = text
    }
}