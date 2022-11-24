package com.example.mobile_programming.Fragment.ListFragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobile_programming.Fragment.MarketInfo.MarketInfoActivity
import com.example.mobile_programming.R
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_first, container, false)

        val list_array = arrayListOf<ContentListModel>(
            
            ContentListModel(R.drawable.list1,"언어1",1,"d"),
            ContentListModel(R.drawable.list2,"언어2",1,"d"),
            ContentListModel(R.drawable.list3,"언어3",1,"d"),
            ContentListModel(R.drawable.list4,"언어4",1,"d"),
            ContentListModel(R.drawable.list5,"언어5",1,"d"),
            ContentListModel(R.drawable.list6,"언어6",1,"d"),
            ContentListModel(R.drawable.list7,"언어7",1,"d"),
            ContentListModel(R.drawable.list8,"언어8",1,"d"),
            ContentListModel(R.drawable.list9,"언어9",1,"d")
        )
        
        val list_adapter = FirstFragAdapter(requireContext(), list_array)
        view.listview_first_fragment.adapter = list_adapter

      view.listview_first_fragment.setOnItemClickListener { parent, view, position, id ->
          val intent = Intent(requireContext(), MarketInfoActivity:: class.java)
          startActivity(intent)
      }

        return view
    }


}