package com.example.mobile_programming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.mobile_programming.Fragment.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_lecutre.*

class LecutreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lecutre)


        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        list_viewpager.adapter = fragmentAdapter

        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("AI")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("CSS")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("HTML")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("ID")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JPG")))
        tab_layout.addTab(tab_layout.newTab().setCustomView(createTabView("JS")))

        list_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    list_viewpager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun createTabView(tabName: String) : View {

        val tabView = LayoutInflater.from(baseContext).inflate(R.layout.custon_tab, null)
        val txt_name =  tabView.findViewById(R.id.txt_name) as TextView
        txt_name.text = tabName
        return tabView
    }
}