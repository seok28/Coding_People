package com.example.mobile_programming.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mobile_programming.MainActivity
import com.example.mobile_programming.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_join_info.*


class JoinInfoActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_join_info)

        auth = FirebaseAuth.getInstance()
        FirebaseApp.initializeApp(this);
        join_info_login_button.setOnClickListener {

            val city = hashMapOf(
                "nickname" to join_info_email_area.text.toString()
            )

            db.collection("user")
                .document(auth.currentUser?.uid.toString())
                .set(city)
                .addOnSuccessListener { Log.e("JoinInfoActivity", "성공") }
                .addOnFailureListener { e -> Log.e("JoinInfoActivity", "실패 ",e) }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            finish()

        }


    }
}