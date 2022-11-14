package com.example.mobile_programming.Fragment.MarketInfo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.mobile_programming.R

class ListAdapter (val context: Context, val list_price :ArrayList<String>,  val list_name : ArrayList<String> )  :BaseAdapter() {
    override fun getCount(): Int {
       return list_name.size
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

        return view
    }

}