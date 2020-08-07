package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_catagory.*
import kotlinx.android.synthetic.main.activity_login.*

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

        //회원가입 버튼 클릭
        button_logout.setOnClickListener{
            val intent = Intent(this,login_activity::class.java)
            startActivity(intent)
        }

    }
    var lastTimeBackPressed : Long = 0
    override fun onBackPressed() {
        if(System.currentTimeMillis() - lastTimeBackPressed >= 1500){
            lastTimeBackPressed = System.currentTimeMillis()
            Toast.makeText(this,"'뒤로' 버튼을 한번 더 누르시면 종료됩니다.",Toast.LENGTH_LONG).show() }
        else {
            ActivityCompat.finishAffinity(this)
            System.runFinalization()
            System.exit(0)
        }
    }
}