package fr.isen.dylanmetans.androidtoolbox

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import android.content.SharedPreferences


class LoginActivity : AppCompatActivity() {

    companion object {
        const val kPassword = "kPassword"
        const val kIdentifier = "kIdentifier"
    }

    private val sharedPreferencesFile = "kotlinsharedpreference"
    private var sharedPreferences: SharedPreferences? = null

    private val goodIdentifier = "admin"
    private val goodPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences =
            this.getSharedPreferences(sharedPreferencesFile, Context.MODE_PRIVATE)


        val buttonValidate = findViewById<Button>(R.id.button_validate)
        buttonValidate.setOnClickListener {

            val id: String = editTextEmail.text.toString()
            val password: String = editTextPassword.text.toString()

            if (loginCheck(id, password)) {

                //Shared preferences creation
                savePreferences(id, password)

                //Start new activity
                val intentHomePage = Intent(this, HomeActivity::class.java)
                intentHomePage.flags =
                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentHomePage)
                finish()
            }

            //Show "toast" error text
            else {
                Toast.makeText(this, "LOGIN ERRRRRRROR", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loginCheck(identifier: String, password: String): Boolean {
        if (identifier == goodIdentifier && password == goodPassword) {

            val id = sharedPreferences?.getString(kIdentifier, null) ?: ""
            val pass = sharedPreferences?.getString(kPassword, null) ?: ""
            editTextEmail.setText(id)
            editTextPassword.setText(pass)
        }
        return identifier == goodIdentifier && password == goodPassword
    }

    private fun savePreferences(identifier: String, password: String) {

        val editor = sharedPreferences?.edit()
        editor?.putString("id_key", identifier)
        editor?.putString("password_key", password)
        editor?.apply()
        editor?.commit()

        val sharedIdValue = sharedPreferences?.getString(kIdentifier, "defaultid")
        val sharedPasswordValue = sharedPreferences?.getString(kPassword, "defaultname")

        Toast.makeText(
            this,
            "Saved:Email" + sharedIdValue.toString() + "\nSaved:Password" + sharedPasswordValue.toString(),
            Toast.LENGTH_LONG
        ).show()
    }

}
