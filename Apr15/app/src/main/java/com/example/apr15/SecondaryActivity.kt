package com.example.apr15

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondaryActivity : AppCompatActivity() {

    var op = ADD

    lateinit var edit1 : EditText
    lateinit var edit2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.secondary)
        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)

        if (intent.hasExtra(OP))
            op = intent.getStringExtra(op)?: op
    }

    fun buttonClick(view: View) {


        Log.v(LOGTAB, "${edit1.text.toString().toDouble()} + ${edit2.text.toString().toDouble()}")

        val a = edit1.text.toString().toDouble()
        val b = edit2.text.toString().toDouble()


        var result = 0.0
        when(op) {
            ADD -> result = a + b
            SUB -> result = a - b
        }

        Log.v(LOGTAB, "Ergebnis: $result")
        var resultS = result.toString()
        setResult(0, intent.apply { putExtra(RESULT, resultS) })
        finish()
    }

    override fun onNewIntent(intent: Intent) {
        Log.v(LOGTAB, intent.getStringExtra(op).toString())
        super.onNewIntent(intent)
        if (intent.hasExtra(OP))
        // in Java: intent.getStringExtra(op) == null ? op : intent.getStringExtra(op)
            op = intent.getStringExtra(op)?: op

    }

    override fun onResume() {
        super.onResume()
        Log.v(LOGTAB, "SecActivity onResume")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOGTAB, "SecActivity onDestroy")
    }
}