package fr.isen.dylanmetans.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

class LifeCycleActivity : AppCompatActivity(),OnFragmentInteractionListener  {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        val fragmentDemo = FragmentDemo()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, fragmentDemo).commit()


        Log.i("TAG","onCreate called")
    }

    override fun onStart() {
        super.onStart()
        Log.i("TAG", "onStart called")
    }
/*    override fun onResume() {
        super.onResume()
        textViewLifeCycle.text = "onResume"
    }
 */

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
        Toast.makeText(
            this,
            "DESTROYED",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun swipeFragment() {
        val secondFragment = FragmentDemo2()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,secondFragment).commit()
    }

}

