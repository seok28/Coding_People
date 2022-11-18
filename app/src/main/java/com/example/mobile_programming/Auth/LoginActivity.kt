package com.example.mobile_programming.Auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mobile_programming.MainActivity
import com.example.mobile_programming.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        FirebaseApp.initializeApp(this);
        login_button.setOnClickListener {
            auth.signInWithEmailAndPassword(email_area.text.toString(), password_area.text.toString())
                .addOnCompleteListener(this)  { task ->
                    if(task.isSuccessful) {
                        // 회원 가입 성공
                        val intent= Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // 로그인 실패
                        Toast.makeText(baseContext, "인증에 실패하였습니다." , Toast.LENGTH_SHORT).show()
                    }
                }
        }

        join_button.setOnClickListener {
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
    }
}