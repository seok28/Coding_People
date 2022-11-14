package com.example.mobile_programming.Fragment


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
            
            ContentListModel("a","1번영상",1,"d"),
            ContentListModel("a","2번영상",1,"d"),
            ContentListModel("a","3번영상",1,"d"),
            ContentListModel("a","4번영상",1,"d"),
            ContentListModel("a","5번영상",1,"d")
            
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