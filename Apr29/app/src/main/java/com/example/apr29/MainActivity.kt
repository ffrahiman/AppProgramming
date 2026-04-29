package com.example.apr29

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
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
import com.example.apr29.ui.theme.Apr29Theme
import java.io.File

const val LOGTAG = "MAIN_ACTIVTY"
const val FOLDER = "Directory"
class MainActivity : ComponentActivity() {

    lateinit var list : ListView

    private val itemClickListener = AdapterView.OnItemClickListener { p: AdapterView<*>, v: View, i: Int, id : Long ->
        if ( v is TextView ) {
            Log.v(LOGTAG, "${v.text}")
            startActivity(Intent(applicationContext, MainActivity::class.java).also {
                it.putExtra(FOLDER, v.text)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main)
        list = findViewById(R.id.list)

        val adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1)

        if( intent.hasExtra(FOLDER)) {
            val file = File(intent.getStringExtra(FOLDER))
            if ( file.isDirectory )
                file.listFiles().forEach {
                    adapter.add(it.path)
                }
            else if(file.isFile) {
                startActivity(Intent(applicationContext, ViewerActivity::class.java).apply {
                    putExtra(FILE, file.path)
                })
                finish()
            }
        }
        else {
            adapter.addAll(
                dataDir.path, filesDir.path, cacheDir.path,
                externalCacheDir?.path,
                Environment.getRootDirectory().path,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).path,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).path,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).path,
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path
            )
        }
        list.adapter = adapter

        list.onItemClickListener = itemClickListener



//        list.setOnItemClickListener { p: AdapterView<*>, v: View, i: Int, id : Long ->
//            if ( v is TextView ) {
//                Log.v(LOGTAG, "${v.text}")
//                startActivity(Intent(applicationContext, MainActivity::class.java).also {
//                    it.putExtra(FOLDER, v.text)
//                })
//            }
//        }

//        Environment.getRootDirectory().listFiles().forEach {
//            Log.v(LOGTAG, it.path)
//        }
    }
}


