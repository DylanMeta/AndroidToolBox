package fr.isen.dylanmetans.androidtoolbox

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat


class TestAgeValue {

    private fun setup(): SaveActivity {

        val date = SaveActivity()
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        date.currentDate = formatter.parse("28/01/2020")
        return date
    }

    @Test
    fun simpleYear_test() {
        val date = setup()
        val age = date.testAgeValue(2000,1,1)
        assertEquals(20, age)
    }

    @Test
    fun simpleMonth_test() {
        val date = setup()
        val age = date.testAgeValue(2000, 2, 1)
        assertEquals(19, age)
    }

    @Test
    fun simpleDay_test() {
        val date = setup()
        val age = date.testAgeValue(2000, 1, 29)
        assertEquals(19, age)
    }
}