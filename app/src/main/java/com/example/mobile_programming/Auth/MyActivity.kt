package com.example.mobile_programming.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobile_programming.R
//import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_my.*


class MyActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my)

        auth = FirebaseAuth.getInstance()

//        FirebaseApp.initializeApp(this);
        logout_btn.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val docRef = db.collection("user").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener { documentSnapshot ->
           nickname_area.setText(documentSnapshot.get("nickname").toString())

        }

    }
}