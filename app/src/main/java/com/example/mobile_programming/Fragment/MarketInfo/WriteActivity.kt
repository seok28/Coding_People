package com.example.mobile_programming.Fragment.MarketInfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.mobile_programming.MainActivity
import com.example.mobile_programming.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    private lateinit var rating_num : String

    private lateinit var nickname : String

    private lateinit var auth : FirebaseAuth

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        auth = FirebaseAuth.getInstance()


        // rating(별점)

        rating_area.setOnRatingBarChangeListener { ratingBar, fl, b ->
            rating_num = fl.toString()
        }

        // 닉네임 값  받아오기
        val docRef = db.collection("user").document(auth.currentUser?.uid.toString())

        docRef.get().addOnSuccessListener { documentSnapshot ->
            nickname = documentSnapshot.get("nickname") as String
        }

        writing_button.setOnClickListener {

            val form = hashMapOf(

                "text" to text_input_area.text.toString(),
                "writer" to nickname,
                "rating" to rating_num

            )

            db.collection("reviews")
                .add(form)
                .addOnSuccessListener { Log.d("WriteActivity", "성공함") }
                .addOnFailureListener { e-> Log.w("WriteActivity","에러 발생",e) }


                Toast.makeText(this, "리뷰가 작성되었습니다.",Toast.LENGTH_LONG).show()

                val intent = Intent(this, ReviewFragment::class.java)
                startActivity(intent)

                finish()

        }

    }
}