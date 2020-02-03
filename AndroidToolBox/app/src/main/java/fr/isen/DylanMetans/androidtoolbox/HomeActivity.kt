package fr.isen.dylanmetans.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class HomeActivity : AppCompatActivity() {

    private val sharedPreferencesFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val buttonLifeCycle = findViewById<ImageButton>(R.id.imageButtonLifeCycle)
        buttonLifeCycle.setOnClickListener {
            //Start activity
            val intentLifeCycle = Intent(this, LifeCycleActivity::class.java)
            startActivity(intentLifeCycle)
        }


        val buttonPermission = findViewById<ImageButton>(R.id.imageButtonPermissions)
        buttonPermission.setOnClickListener {
            //Start activity
            val intentPermission = Intent(this, PermissionsActivity::class.java)
            startActivity(intentPermission)
        }

        val buttonSave = findViewById<ImageButton>(R.id.imageButtonSave)
        buttonSave.setOnClickListener {
            //Start activity
            val intentSave = Intent(this, SaveActivity::class.java)
            startActivity(intentSave)
        }


        val buttonWebServices = findViewById<ImageButton>(R.id.imageButtonWebservices)
        buttonWebServices.setOnClickListener {
            //Start activity
            val intentWebServices = Intent(this, WebServicesActivity::class.java)
            startActivity(intentWebServices)
        }


        val buttonDisconnect = findViewById<Button>(R.id.button_disconnect)
        buttonDisconnect.setOnClickListener {
            //Shared preferences delete ---------------------------------------------------------
            val sharedPreferences: SharedPreferences = getSharedPreferences(sharedPreferencesFile, Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            //Start new activity
            val intentLogin = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intentLogin)
            finish()
        }
    }
}
