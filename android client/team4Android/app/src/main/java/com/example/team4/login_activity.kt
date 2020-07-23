package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //로그인 버튼 클릭
        button_login.setOnClickListener{
            Log.i("testLog", edit_id.text.toString())
            Log.i("testLog", edit_pw.text.toString())

            val inputId = edit_id.text.toString()
            val inputPw = edit_pw.text.toString()

            if(inputId == "admin" && inputPw == "1234"){ //로그인이 성공했을 경우
                val intent = Intent(this,catagory_activity ::class.java)
                startActivity(intent)
            }
            else Toast.makeText(this, "아이디와 비밀번호를 확인해주세요"
                , Toast.LENGTH_SHORT).show()
        }
        
        //회원가입 버튼 클릭
        button_register.setOnClickListener{
            val intent = Intent(this,join_acticity ::class.java)
            startActivity(intent)
        }


    }
}