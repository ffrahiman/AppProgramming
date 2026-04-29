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
const val NAME = "NAME"
const val SIZE = "SIZE"
const val TYPE = "TYPE"
const val RIGHTS = "RIGHTS"
class MainActivity : ComponentActivity() {

    lateinit var list : ListView

    private val itemClickListener = AdapterView.OnItemClickListener { p: AdapterView<*>, v: View, i: Int, id : Long ->
        val text1 = v.findViewById<TextView>(R.id.text1)
        Log.v(LOGTAG, "${text1.text}")
        startActivity(Intent(applicationContext, MainActivity::class.java).also {
            it.putExtra(FOLDER, text1.text)
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main)
        list = findViewById(R.id.list)

        val mutableList : MutableList<Map<String, String>> = mutableListOf()
        val root = Environment.getRootDirectory()

        if( intent.hasExtra(FOLDER)) {
            val file = File(intent.getStringExtra(FOLDER))
            if ( file.isDirectory )
                file.listFiles().forEach {
                    mutableList.add(mapOf( NAME to it.absolutePath, SIZE to it.length().toString(), TYPE to if ( it.isDirectory() ) "d" else if( it.isFile() ) "f" else "-", RIGHTS to "${if (it.canRead()) 'r' else '-'} ${if( it.canWrite() ) 'w' else '-'} ${if( it.canExecute() ) 'x' else '-'}"))
                    Log.v(LOGTAG, "${it.name} ${it.length()} ${if ( it.isDirectory() ) 'd' else if( it.isFile() ) 'f' else '-'} ${if( it.canRead() ) 'r' else '-'} ${if( it.canWrite() ) 'w' else '-'} ${if( it.canExecute() ) 'x' else '-'}")
                }
            else if(file.isFile) {
                startActivity(Intent(applicationContext, ViewerActivity::class.java).apply {
                    putExtra(FILE, file.path)
                })
                finish()
            }
        }
        else {
            mutableList.add(mapOf( NAME to root.absolutePath, SIZE to root.length().toString(),
                TYPE to if ( root.isDirectory() ) "d" else if( root.isFile() ) "f" else "-", RIGHTS to "${if (root.canRead()) 'r' else '-'} ${if( root.canWrite() ) 'w' else '-'} ${if( root.canExecute() ) 'x' else '-'}"))

            mutableList.add(mapOf( NAME to dataDir.absolutePath, SIZE to dataDir.length().toString(),
                TYPE to if ( dataDir.isDirectory() ) "d" else if( dataDir.isFile() ) "f" else "-", RIGHTS to "${if (dataDir.canRead()) 'r' else '-'} ${if( dataDir.canWrite() ) 'w' else '-'} ${if( dataDir.canExecute() ) 'x' else '-'}"))
        }
        val adapter = SimpleAdapter(applicationContext, mutableList, R.layout.list_item, arrayOf(NAME, SIZE, TYPE, RIGHTS), intArrayOf(R.id.text1, R.id.text2, R.id.text3, R.id.text4))

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


