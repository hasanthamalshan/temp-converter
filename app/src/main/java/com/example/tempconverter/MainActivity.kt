package com.example.tempconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Temperature Converter"

        val temperatureUnits = arrayOf("Celsius", "Fahrenheit")

        val fromUnitSpinner: Spinner = findViewById(R.id.fromUnit)
        val toUnitSpinner: Spinner = findViewById(R.id.toUnit)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, temperatureUnits)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        fromUnitSpinner.adapter = adapter
        toUnitSpinner.adapter = adapter

        val buttonConvert: Button = findViewById(R.id.buttonConvert)
        val fromValueEditText: EditText = findViewById(R.id.fromValue)
        val resultTextView: TextView = findViewById(R.id.textViewResult)

        buttonConvert.setOnClickListener {
            val fromUnit = fromUnitSpinner.selectedItem.toString()
            val toUnit = toUnitSpinner.selectedItem.toString()
            val fromValue = fromValueEditText.text.toString().toDoubleOrNull()

            if (fromValue != null) {
                val result = convertTemperature(fromValue, fromUnit, toUnit)
                resultTextView.text = "Result: $result $toUnit"
            } else {
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun convertTemperature(value: Double, fromUnit: String, toUnit: String): Double {
        return if (fromUnit == toUnit) {
            value
        } else if (fromUnit == "Celsius" && toUnit == "Fahrenheit") {
            value * 9/5 + 32
        } else if (fromUnit == "Fahrenheit" && toUnit == "Celsius") {
            (value - 32) * 5/9
        } else {
            value
        }
    }
}