package fr.isen.DylanMetans.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var buttonLifeCycle = findViewById<ImageButton>(R.id.imageButtonLifeCycle)
        buttonLifeCycle.setOnClickListener {
            //Start activity
            val intentLifeCycle = Intent(this, LifeCycleActivity::class.java)
            startActivity(intentLifeCycle)
        }
    }
}
