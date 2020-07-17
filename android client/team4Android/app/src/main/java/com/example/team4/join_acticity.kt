package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_join.*

class join_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        //뒤로가기 버튼
        button_back.setOnClickListener{
            val intent = Intent(this, login_acticity::class.java) //LIstPageActivity로 이동
            startActivity(intent)
        }

        //회원가입 완료 버튼
        button_set.setOnClickListener {
            //if()
            val intent = Intent(this, login_acticity::class.java) //LIstPageActivity로 이동
            startActivity(intent)}

    }
}