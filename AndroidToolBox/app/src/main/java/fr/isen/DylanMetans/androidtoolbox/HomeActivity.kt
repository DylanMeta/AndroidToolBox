package fr.isen.dylanmetans.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPreferences: SharedPreferences = LoginActivity.getSharedPreferences(LoginActivitysharedPreferencesFile,Context.MODE_PRIVATE)


            val buttonLifeCycle = findViewById<ImageButton>(R.id.imageButtonLifeCycle)
        buttonLifeCycle.setOnClickListener {
            //Start activity
            val intentLifeCycle = Intent(this, LifeCycleActivity::class.java)
            startActivity(intentLifeCycle)
        }
            Context.MODE_PRIVATE)


        val buttonDeconnect = findViewById<Button>(R.id.button_deconnect)
        val intentHomePage = Intent(this, HomeActivity::class.java)

        button_deconnect.setOnClickListener {
//Shared preferences delete ---------------------------------------------------------


                //Start new activity
                intentHomePage.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentHomePage)

    }
}
