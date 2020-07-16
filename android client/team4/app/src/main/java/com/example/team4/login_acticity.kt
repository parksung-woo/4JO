package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_join.button
import kotlinx.android.synthetic.main.activity_login.*

class login_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //로그인 버튼 클릭
        button.setOnClickListener{
            //if()//로그인이 성공했을 경우
            {
                val intent = Intent(this,loginMain_acticity ::class.java)
                startActivity(intent)
            }
            //로그인 실패
            /*else*/ Toast.makeText(this, "아이디와 비밀번호를 확인해주세요"
                , Toast.LENGTH_SHORT).show()

            val intent = Intent(this,loginMain_acticity ::class.java)
            startActivity(intent)
        }
        
        //회원가입 버튼 클릭
        button2.setOnClickListener{
            val intent = Intent(this, join_acticity::class.java)
            startActivity(intent)
        }
    }
}