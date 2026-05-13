package com.example.may06

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.SeekBar
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
import com.example.may06.databinding.MainBinding
import com.example.may06.ui.theme.May06Theme
import java.io.File

const val LOGTAG = "MAIN_ACTIVITY"
class MainActivity : ComponentActivity() {

    lateinit var binding : MainBinding

    //has to be nullable since file does not exist yet
    var userFile : File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.edit1.setOnKeyListener { v, keyCode, event ->
//            Log.v(LOGTAG, "${v} ${keyCode} ${event}")
//            true
//        }

//        val watcher = object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit
//
//            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                Log.v(LOGTAG, "onTextChanged: $s")
//            }
//
//            override fun afterTextChanged(s: Editable?) = Unit
//        }
//        binding.edit1.addTextChangedListener(watcher)

        // have to specify after context is made as earlier file does not exist

        with(File("${filesDir.absolutePath}/user.txt")) {
            createNewFile()
            userFile = this
        }

//        userFile = File("${filesDir.absolutePath}/user.txt")
//        userFile?.createNewFile()
//        if( !(userFile?.exists() ?: true))
//            userFile?.createNewFile()
        val listener = object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, frontUser: Boolean) {
                binding.text2.text = progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) = Unit

            override fun onStopTrackingTouch(p0: SeekBar?) = Unit
        }
        binding.seek1.setOnSeekBarChangeListener(listener)
    }


    override fun onResume() {
        super.onResume()

        try {
            userFile?.reader().run {
                binding.edit1.setText(readln())
                binding.seek1.progress = readln().toInt()
            }
        } catch(e: Exception){}

        binding.edit1.setText(userFile?.readText())
    }

    override fun onPause() {
        super.onPause()
        userFile?.writer()?.run{
            write(binding.edit1.text.toString())
            write("\n")
            write(binding.seek1.progress.toString())
            flush()
            close()
        }
    }
}
