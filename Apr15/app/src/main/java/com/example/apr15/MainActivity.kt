package com.example.apr15

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val LOGTAB = "MAIN_ACTIVITY"
const val OP = "Operation"
const val ADD = "Addieren"
const val SUB = "Subtrahieren"
const val RESULT = "Ergebnis"

class MainActivity: AppCompatActivity() {

    lateinit var textview : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v(LOGTAB, "MainActivity created")
        setContentView(R.layout.main)
        textview = findViewById(R.id.textview)
    }

    fun buttonClickMain(view : View) {

        startActivityForResult(Intent(applicationContext, SecondaryActivity::class.java).apply {
            when(view.id){
                R.id.addButton -> { putExtra(OP, ADD); Log.v(LOGTAB, "Addieren") }
                R.id.subButton -> { putExtra(OP, SUB); Log.v(LOGTAB, "Subtrahieren") }
            }
        }, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ( requestCode == 101 ) {
            Log.v(LOGTAB, "$requestCode $resultCode ${data?.extras?.getDouble(RESULT)}")
            textview.text = data?.extras?.getString(RESULT).toString()
        }
    }

    @SuppressLint("UnsafeImplicitIntentLaunch")
    fun exitButton(view: View) {
        super.onResume()
        Log.v(LOGTAB, "MainActivity exit")
        startActivity(Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_EMAIL, "info@hof-university.de")
            putExtra(Intent.EXTRA_TEXT, "Sehr geehrte Damen und Herren,...")
            putExtra(Intent.EXTRA_CC, "sek-inf@hof-university.de")
            type="text/plain"
        })
        finish()
    }

    fun buttonCall(view: View) {
        Log.v(LOGTAB, "MainActivtiy calls the police")
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:110")))
    }

    fun buttonView(view: View) {
        Log.v(LOGTAB, "MainActivity calls the police")
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people")))
//        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.hof-university.de")))
    }

    override fun onResume() {
        super.onResume()
        Log.v(LOGTAB, "MainActivity onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(LOGTAB, "MainActivity onDestroy")
    }
}