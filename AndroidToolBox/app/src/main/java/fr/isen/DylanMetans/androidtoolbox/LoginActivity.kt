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

    private val sharedPreferencesFile = "kotlinsharedpreference"

    private val goodIdentifier = "admin"
    private val goodPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /*var inputId = findViewById<EditText>(R.id.editTextEmail)
        //val outputName = findViewById<TextView>(R.id.textViewShowName)
        var inputPassword = findViewById<EditText>(R.id.editTextPassword)
        //val outputId = findViewById<TextView>(R.id.textViewShowId)
        */
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPreferencesFile,Context.MODE_PRIVATE)


        val buttonValidate = findViewById<Button>(R.id.button_validate)
        val intentHomePage = Intent(this, HomeActivity::class.java)

        buttonValidate.setOnClickListener {

            if (canLog(editTextEmail.text.toString(),editTextPassword.text.toString()) ){

//Shared preferences creation ---------------------------------------------------------
                val id : String = editTextEmail.text.toString()
                val password : String = editTextPassword.text.toString()
                val editor: SharedPreferences.Editor = sharedPreferences.edit()

                editor.putString("id_key",id)
                editor.putString("password_key",password)
                editor.apply()
                editor.commit()

                val sharedIdValue = sharedPreferences.getString("id_key","defaultid")
                val sharedNameValue = sharedPreferences.getString("name_key","defaultname")

                Toast.makeText(this, "Saved:Email" + sharedIdValue.toString() +"\nSaved:Password" + sharedNameValue.toString(), Toast.LENGTH_LONG).show()


                //Start new activity
                intentHomePage.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intentHomePage)
            }
            //Show "toast" error text
            else {


                Toast.makeText(this,"LOGIN ERRRRRRROR",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun canLog(identifier:String, password:String) : Boolean {
        return identifier == goodIdentifier && password == goodPassword
    }
}