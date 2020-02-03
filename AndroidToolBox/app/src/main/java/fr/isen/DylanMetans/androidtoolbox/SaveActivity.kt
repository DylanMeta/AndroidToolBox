package fr.isen.dylanmetans.androidtoolbox

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_form.*
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class SaveActivity : AppCompatActivity() {

    companion object {
        const val FirstNameId = "FirstNameId"
        const val LastNameId = "LastNameId"
        const val BirthDayId = "BirthDayId"
        const val FilenameId = "usersData.json"
    }

    var currentDate = Date()

    private val firstName =  findViewById<EditText>(R.id.editTextFirstName)
    private val name = findViewById<EditText>(R.id.editTextName)
    private val birthDay =  findViewById<EditText>(R.id.editTextDate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)


        button_submit.setOnClickListener {
            submit()
        }

        button_view.setOnClickListener {
            // TEST EXISTENCE AVANT LE SAVE
            view()
        }

        birthDay.setOnFocusChangeListener {_, hasFocus ->
            if(hasFocus) {
                birthDay.clearFocus()
                val dialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener {_,year, month, dayOfMonth ->
                        editTextDate.setText(String.format("%02d/%02d/%04d", dayOfMonth, month+1, year))
                    },
                    1997,
                    2,
                    15)
                dialog.show()
            }
        }
    }

    private fun submit() {
        if (firstName.text.toString().isNotEmpty() &&
            name.text.toString().isNotEmpty() &&
            birthDay.text.toString().isNotEmpty()) {

            val json = JSONObject()
            val file = File(cacheDir.absolutePath+"/"+FilenameId)

            json.put(FirstNameId, firstName.text.toString())
            json.put(LastNameId, name.text.toString())
            json.put(BirthDayId, birthDay.text.toString())
            Toast.makeText(this, json.toString(), Toast.LENGTH_LONG).show()

            file.writeText(json.toString())

        } else {
            Toast.makeText(this,"", Toast.LENGTH_LONG).show()
        }
    }

    private fun view() {
        val file = File(cacheDir.absolutePath+"/"+FilenameId)
        val readString = file.readText()
        val json = JSONObject(readString)
        Toast.makeText(this,json.getString(BirthDayId), Toast.LENGTH_LONG).show()
    }

    fun testAgeValue(year: Int, month: Int, day: Int): Int {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val currentDateString = formatter.format(currentDate)
        val components = currentDateString.split("/")

        var age = components[2].toInt() - year
            if(components[1].toInt() < month) {
                age--
            }
            else if (components[1].toInt() == month &&
                components[0].toInt() < day){
                age --
            }
        return age
    }


}
