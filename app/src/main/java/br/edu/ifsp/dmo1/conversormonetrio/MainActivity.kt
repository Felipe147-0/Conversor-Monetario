package br.edu.ifsp.dmo1.conversormonetrio

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val DOLLAR_VALUE = 5.71                 // dolar em 28/10/24
    private lateinit var toDollarButton: Button
    private lateinit var toRealButton: Button
    private lateinit var outputTextView: TextView
    private lateinit var inputEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()

    }

    override fun onClick(v: View) {
        when (v.id) {
            toDollarButton.id -> dollarConversion()
            toRealButton.id -> realConversion()
        }
    }

    private fun findById() {
        inputEditText = findViewById(R.id.edittext_value)
        toDollarButton = findViewById(R.id.button_convert_to_dollar)
        toRealButton = findViewById(R.id.button_convert_to_real)
        outputTextView = findViewById(R.id.textview_output)

        toDollarButton.setOnClickListener(this)
        toRealButton.setOnClickListener(this)
    }

    private fun getValue(): Double {
        return try {
            inputEditText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun dollarConversion() {
        val value = getValue() / DOLLAR_VALUE
        outputTextView.text = String.format("U$ %.2f", value)
    }

    private fun realConversion() {
        val value = getValue() * DOLLAR_VALUE
        outputTextView.text = String.format("R$ %.2f", value)
    }
}
