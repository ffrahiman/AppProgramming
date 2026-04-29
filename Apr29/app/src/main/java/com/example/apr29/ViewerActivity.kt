package com.example.apr29

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import java.io.File

const val FILE = "DATEI"

class ViewerActivity : ComponentActivity() {

    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.viewer)

        text = findViewById(R.id.text)

        if( intent.hasExtra(FILE) ) {
            val file = File(intent.getStringExtra(FILE))
            text.text = file.readText()
        }
    }
}