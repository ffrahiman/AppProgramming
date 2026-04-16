package com.example.myapplication

//import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
//import android.widget.TextView
import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.myapplication.ui.theme.MyApplicationTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MyApplicationTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}

const val LOGTAB = "MAIN_ACTIVITY"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val tv = TextView(this)
//        tv.text = "Hello World"
//        setContentView(tv)
        setContentView(R.layout.main)
    }

    fun buttonClick(view: View?) {
        Log.v(LOGTAB, "buttonClick")
        val intent = Intent(applicationContext, SecondActivity::class.java)
        startActivity(intent)
    }

    fun buttonSend(view: View) {
        Log.v(LOGTAB, "buttonSend")

//        val intent = Intent()
//        intent.action = Intent.ACTION_SEND
//        startActivity(intent)
//        analog JAVA

        startActivity(Intent().apply {
            action = Intent.ACTION_SEND
        })
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(LOGTAB, "MainActivity onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.v(LOGTAB, "MainActivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.v(LOGTAB, "MainActivity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.v(LOGTAB, "MainActivity onStop")
    }


}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting("Android")
//    }
//}