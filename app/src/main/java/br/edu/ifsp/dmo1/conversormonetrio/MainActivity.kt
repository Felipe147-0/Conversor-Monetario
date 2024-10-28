package br.edu.ifsp.dmo1.conversormonetrio

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val DOLLAR_VALUE = 5.50
    private lateinit var toDollarButton: Button
    private lateinit var toRealButton: Button
    private lateinit var outputTextView: TextView
    private lateinit var inputEditText: EditText  //pois é

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()
        configClickListener()
    }

    override fun onClick(v: View) {
        if (v == toDollarButton) {
            dollarConversion()
        }else if (v == toRealButton){
            realConversion()
        }
    }

    private fun findById() {
        inputEditText = findViewById(R.id.edittext_value)
        toRealButton.setOnClickListener(this)
        toDollarButton.setOnClickListener(this)
        outputTextView = findViewById(R.id.textview_output)
    }

    private fun configClickListener() {
        toRealButton.setOnClickListener(this)
        toDollarButton.setOnClickListener(this)
    }

    private fun getValue(): Double{
        return try {
            inputEditText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun dollarConversion() {
        var value = getValue()
        value = value / DOLLAR_VALUE
        outputTextView.text = "U$ $value"
    }
    private fun realConversion(){
        var value = getValue()
        value = value * DOLLAR_VALUE
        outputTextView.text = "R$ $value"
    }


}