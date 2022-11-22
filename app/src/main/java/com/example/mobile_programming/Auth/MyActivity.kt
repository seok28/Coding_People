package com.example.mobile_programming.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_programming.MainActivity
import com.example.mobile_programming.R
//import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_my.*
import kotlinx.android.synthetic.main.bottom.*


class MyActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        auth = FirebaseAuth.getInstance()

//        FirebaseApp.initializeApp(this);


        // 로그아웃 기능
        logout_btn.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val docRef = db.collection("user").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener { documentSnapshot ->
           nickname_area.setText(documentSnapshot.get("nickname").toString())

        }
        // 하단 네비게이션 바 클릭 리스너

        home_btn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        my_page.setOnClickListener {
            if(auth.currentUser == null) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }else {
                val intent = Intent(this, MyActivity::class.java)
                startActivity(intent)
            }
        }

    }
}