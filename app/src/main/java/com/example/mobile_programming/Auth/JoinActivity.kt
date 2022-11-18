package com.example.mobile_programming.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobile_programming.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_join.*

class JoinActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_join)
        auth = FirebaseAuth.getInstance()
        FirebaseApp.initializeApp(this);
        join_login_button.setOnClickListener {
            auth.createUserWithEmailAndPassword(join_email_area.text.toString(), join_password_area.text.toString())
                .addOnCompleteListener(this){task ->

                    if (task.isSuccessful) {

                        val intent = Intent(this,JoinInfoActivity::class.java)
                        startActivity(intent)

                    }else {
                        Toast.makeText(this,"실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}