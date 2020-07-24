package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catagory.*

class catagory_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catagory) //로그인 메인 페이지

        //로그아웃

//        button6.setOnClickListener {  val intent = Intent(this,login_activity ::class.java)
//            startActivity(intent) }
//
//        button6.setOnClickListener {
//            val intent = Intent(this,login_activity ::class.java)
//            startActivity(intent)
//        }

        // 농장번호
        cardview1.setOnClickListener {
            val intent = Intent(this,management_activity ::class.java)
            startActivity(intent)
        }
        cardview2.setOnClickListener {
            val intent = Intent(this,management_activity ::class.java)
            startActivity(intent)
        }
        cardview3.setOnClickListener {
            val intent = Intent(this,management_activity ::class.java)
            startActivity(intent)
        }
        cardview4.setOnClickListener {
            val intent = Intent(this,management_activity ::class.java)
            startActivity(intent)
        }
        cardview5.setOnClickListener {
            val intent = Intent(this,management_activity ::class.java)
            startActivity(intent)
        }
        cardview6.setOnClickListener {
            val intent = Intent(this,management_activity ::class.java)
            startActivity(intent)
        }



    }
}