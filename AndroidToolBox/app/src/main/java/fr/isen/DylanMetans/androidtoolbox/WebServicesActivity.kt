package fr.isen.dylanmetans.androidtoolbox

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_permissions.*
import kotlinx.android.synthetic.main.recycler_view_web_cell.*

//TODO: Check on a phone (emulator needs config to works)

class WebServicesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val apiUrl = "https://randomuser.me/api/?results=20"
        val userList= ArrayList<UserModel>()


        // Request a string response from the provided URL.
         val request = StringRequest(Request.Method.GET, apiUrl,Response.Listener {
                 // Display
                 val gsonFile = Gson()
                 val result = gsonFile.fromJson(it,RandomUserModel::class.java)

                 result.results?.forEach() {
                     textPersonName.text = it.name?.first
                     textPersonName2.text = it.name?.last
                     textViewAdress.text = it.location?.street?.name
                     textMail.text = it.email
                     Picasso.get().load(it.picture?.medium).into(imageViewAvatar)
                     userList.add(it)
                 }
        },
        Response.ErrorListener {
            Log.d("Error",it.toString())
        })

 // Add the request to the RequestQueue.
        queue.add(request)

        contactRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        contactRecyclerView.adapter = UserAdapter(userList)


    }


}