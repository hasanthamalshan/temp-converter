package com.example.tempconverter

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
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


    }
}