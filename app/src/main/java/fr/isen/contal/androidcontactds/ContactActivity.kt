package fr.isen.contal.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContactActivity(listecontacts: Any?) : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
    }

    fun updateList(users: Any) {
        TODO("Not yet implemented")
    }

    fun toList(): Any {
        TODO("Not yet implemented")

    }
}