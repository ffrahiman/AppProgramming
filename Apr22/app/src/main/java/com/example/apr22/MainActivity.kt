package com.example.apr22

import android.hardware.biometrics.BiometricManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.apr22.databinding.ActivityMainBinding
import com.example.apr22.ui.theme.Apr22Theme

const val LOGTAG = "MAIN_ACTIVITY"
class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //ActivityMainBinding.inflate(LayoutInflater)
        setContentView(R.layout.activity_main)

//        val fruit = resources.getStringArray(R.array.fruit)
//        fruit.forEach { Log.v(LOGTAG, it) }
//
//        Log.v(LOGTAG, "${binding.spinner.adapter} ${binding.spinner.adapter.count}")

    }
}
