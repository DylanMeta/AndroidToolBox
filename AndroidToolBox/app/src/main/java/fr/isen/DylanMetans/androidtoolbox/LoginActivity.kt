package fr.isen.DylanMetans.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var buttonValidate = findViewById<Button>(R.id.button_validate)

        buttonValidate.setOnClickListener {
            /*Show "toast" text

            if (editTextEmail.text.toString() != "admin" || editTextPassword.text.toString() != "123"){
                Toast.makeText(this,"LOGIN ERRRRRRROR",Toast.LENGTH_LONG).show()

            }

            else {
                Toast.makeText(this, editTextEmail.text.toString(), Toast.LENGTH_LONG).show()
                //Start activity
                val intentHomePage = Intent(this, HomeActivity::class.java)
                startActivity(intentHomePage)
            }*/
        }
    }
}