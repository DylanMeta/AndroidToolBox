package fr.isen.dylanmetans.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_life_cycle.*


class LifeCycleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

       supportFragmentManager.beginTransaction().add(
            R.id.frag1, fragment_one).commit()


        Log.i("TAG","onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TAG", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TAG", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TAG", "onStop called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("TAG", "onRestart called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TAG", "onDestroy called")
    }

//    transaction.remove(firstFragment)

}

