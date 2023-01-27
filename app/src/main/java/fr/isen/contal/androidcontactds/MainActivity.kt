package fr.isen.contal.androidcontactds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import fr.isen.contal.androidcontactds.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ContactActivity
    private lateinit var binding: ActivityMainBinding
    private val queue = Volley.newRequestQueue(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.extras?.getString("app_name") ?: "je suis sûr que ce serai moins vide ici si j'avais eu un cours de kotlin"
        binding.titre.text = title
        binding.listecontacts.layoutManager = LinearLayoutManager(this)

        val recyclerView = findViewById<MainActivity>(R.id.listecontacts)
        val adapter = ContactActivity(recyclerView)
        recyclerView.adapter = adapter


        val url = "https://randomuser.me/api/?results=10&nat=fr"
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                val gson = Gson()
                val users = gson.fromJson(response.toString(), ContactActivity::class.java).toList()
                adapter.updateList(users)

            },
            Response.ErrorListener { error ->

            }
        )
        queue.add(request)















    }
}
