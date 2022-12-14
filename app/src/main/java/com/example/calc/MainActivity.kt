package com.example.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        this.editText = findViewById(R.id.editText)
    }

    fun numberEvent(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        editText.setOnClickListener{
            if(isNewOp)
                editText.setText("")
            isNewOp = false
        }

        var buclick = editText.text.toString()
        var buselect = view as Button

        val bu1 = findViewById<Button>(R.id.bu1)
        val bu2 = findViewById<Button>(R.id.bu2)
        val bu3 = findViewById<Button>(R.id.bu3)
        val bu4 = findViewById<Button>(R.id.bu4)
        val bu5 = findViewById<Button>(R.id.bu5)
        val bu6 = findViewById<Button>(R.id.bu6)
        val bu7 = findViewById<Button>(R.id.bu7)
        val bu8 = findViewById<Button>(R.id.bu8)
        val bu9 = findViewById<Button>(R.id.bu9)
        val bu0 = findViewById<Button>(R.id.bu0)
        val buDot = findViewById<Button>(R.id.buDot)
        val buPlusMinus = findViewById<Button>(R.id.buPlusMinus)


        when(buselect.id) {
            bu1.id -> {buclick += "1"}
            bu2.id -> {buclick += "2"}
            bu3.id -> {buclick += "3"}
            bu4.id -> {buclick += "4"}
            bu5.id -> {buclick += "5"}
            bu6.id -> {buclick += "6"}
            bu7.id -> {buclick += "7"}
            bu8.id -> {buclick += "8"}
            bu9.id -> {buclick += "9"}
            bu0.id -> {buclick += "0"}
            buDot.id -> {buclick += "."}
            buPlusMinus.id -> {buclick = "-$buclick"}
        }
        editText.setText(buclick)
    }

    fun operatorEvent(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        editText.setOnClickListener {
            isNewOp = true
            oldNumber = editText.text.toString()
        }

        var buclick = editText.text.toString()
        var buselect = view as Button

        val buMultiply = findViewById<Button>(R.id.buMultiply)
        val buDivide = findViewById<Button>(R.id.buDivide)
        val buPlus = findViewById<Button>(R.id.buPlus)
        val buMinus = findViewById<Button>(R.id.buMinus)

        when (buselect.id) {
            buMultiply.id -> {
                op = "*"
            }
            buDivide.id -> {
                op = "/"
            }
            buPlus.id -> {
                op = "+"
            }
            buMinus.id -> {
                op = "-"
            }
        }
    }

    fun equalEvent(view: View) {
        val editText = findViewById<EditText>(R.id.editText)

        editText.setOnClickListener{
            var newnumber = editText.text.toString()
            var result = 0.0

            when(op) {
                "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
                "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
                "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
                "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}
            }
            editText.setText{result.toString()
        }
    }
}

    fun percentEvent(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        editText.setOnClickListener{
            val buPercentage = findViewById<Button>(R.id.buPercentage)
            var no = editText.text.toString().toDouble()/100
            editText.setText(no.toString())
            isNewOp = true
    }
}

private fun EditText.setText(function: () -> String) {}
    fun acEvent(view: View) {
        editText.setOnClickListener {
            editText.setText("0")
            isNewOp = true
        }
}}
