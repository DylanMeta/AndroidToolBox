package fr.isen.dylanmetans.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    private val sharedPreferencesFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

// 4 image button with their own activity attached
        imageButtonLifeCycle.setOnClickListener {
            //Start activity
            val intentLifeCycle = Intent(this, LifeCycleActivity::class.java)
            startActivity(intentLifeCycle)
        }

        imageButtonPermissions.setOnClickListener {
            //Start activity
            val intentPermission = Intent(this, PermissionsActivity::class.java)
            startActivity(intentPermission)
        }

        imageButtonSave.setOnClickListener {
            //Start activity
            val intentSave = Intent(this, SaveActivity::class.java)
            startActivity(intentSave)
        }

        imageButtonWebservices.setOnClickListener {
            //Start activity
            val intentWebServices = Intent(this, WebServicesActivity::class.java)
            startActivity(intentWebServices)
        }


// Disconnect and forget the mail and password given
        button_disconnect.setOnClickListener {
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
