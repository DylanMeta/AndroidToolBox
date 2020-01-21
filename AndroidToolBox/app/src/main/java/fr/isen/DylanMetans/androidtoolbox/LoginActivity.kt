package fr.isen.DylanMetans.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    val goodIdentifier = "admin"
    val goodPassword = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonValidate = findViewById<Button>(R.id.button_validate)
        val intentHomePage = Intent(this, HomeActivity::class.java)


        buttonValidate.setOnClickListener {
            /*Show "toast" text */
            if (canLog(editTextEmail.text.toString(),editTextPassword.text.toString()) ){
                //Start activity
                startActivity(intentHomePage)

                Toast.makeText(this, "Welcome, " + editTextEmail.text.toString(), Toast.LENGTH_LONG).show()
            }

            else {
                Toast.makeText(this,"LOGIN ERRRRRRROR",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun canLog(identifier:String, password:String) : Boolean {
        return identifier == goodIdentifier && password == goodPassword
    }
}