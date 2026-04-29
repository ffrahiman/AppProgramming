package com.example.apr29

import android.content.Context
import android.database.DataSetObserver
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import java.io.File


// class FileAdapter(context: Context, files, List<File>, res : Int) : Adapter
//class FileAdapter(context: Context, data : MutableList<Map<String, String>>, res: Int, from: Array<String>, to: IntArray) : SimpleAdapter(context, data,res, from, to) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        Log.v(LOGTAG, "$position $convertView $parent")
//        return super.getView(position, convertView, parent)
//    }
//}

class FileAdapter(val context: Context, val files: List<File>, val res : Int) : Adapter {

    override fun getCount(): Int = files.count()

    override fun getItem(position: Int): Any? = files[position]

    override fun getItemId(position: Int): Long = files[position].hashCode().toLong()

    override fun getItemViewType(p0: Int): Int {
        return Adapter.IGNORE_ITEM_VIEW_TYPE
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        val view = if ( convertView == null ) LayoutInflater.from(context).inflate(res, null) else convertView
        view.findViewById<TextView>(R.id.text1).text = "Hallo Welt!"
        return view

    }

    override fun getViewTypeCount(): Int = 1

    override fun hasStableIds(): Boolean = true

    override fun isEmpty(): Boolean = files.isEmpty()

    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }
}