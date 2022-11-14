package com.example.mobile_programming.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mobile_programming.R

class FirstFragAdapter (val context: Context, val list: ArrayList<ContentListModel>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val holder : ViewHolder

        if ( convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, null)

            holder = ViewHolder()

            holder.view_image1 = view.findViewById(R.id.imageview)
            holder.view_text1 = view.findViewById(R.id.lv_textview_1)
            holder.view_text2 = view.findViewById(R.id.lv_textview_2)
            holder.view_text3 = view.findViewById(R.id.lv_textview_3)

            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        val item = list[position]
        holder.view_text1?.text = item.title

        return view

    }

    private class ViewHolder {
        var view_image1 : ImageView? = null
        var view_text1 : TextView? = null
        var view_text2 : TextView? = null
        var view_text3 : TextView? = null
    }

}