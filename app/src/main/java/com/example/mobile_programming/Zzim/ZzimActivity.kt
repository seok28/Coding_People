package com.example.mobile_programming.Zzim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_programming.R
import com.example.mobile_programming.Utils.FirebaseUtils
import kotlinx.android.synthetic.main.activity_zzim.*

class ZzimActivity : AppCompatActivity() {

    val array_List = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zzim)


        FirebaseUtils.db
            .collection("zzim")
            .document(FirebaseUtils.getUid())
            .get()
            .addOnSuccessListener { documentSnapshot ->
                if(documentSnapshot.get("Lang1") !="") {
                    array_List.add("Lang1")
                }
                if(documentSnapshot.get("Lang2") !="") {
                    array_List.add("Lang2")
                }
                if(documentSnapshot.get("Lang3") !="") {
                    array_List.add("Lang3")
                }
                if(documentSnapshot.get("Lang4") !="") {
                    array_List.add("Lang4")
                }
                if(documentSnapshot.get("Lang5") !="") {
                    array_List.add("Lang5")
                }
                if(documentSnapshot.get("Lang6") !="") {
                    array_List.add("Lang6")
                }
                if(documentSnapshot.get("Lang7") !="") {
                    array_List.add("Lang7")
                }
                if(documentSnapshot.get("Lang8") !="") {
                    array_List.add("Lang8")
                }
                if(documentSnapshot.get("Lang9") !="") {
                    array_List.add("Lang9")
                }
                val zzimAdapter = ZzimAdapter(this,array_List)
                zzim_listview.adapter = zzimAdapter

            }
            .addOnFailureListener {  }
    }
}