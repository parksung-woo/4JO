package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*

class join_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)
        //회원가입 완료 버튼
        button_signup.setOnClickListener {
            Toast.makeText(this, "회원가입을 성공했습니다."
                , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, login_activity::class.java) //LIstPageActivity로 이동
//            intent.putExtra("id",user_id.text.toString())
//            Log.i("testLog user_id -> ", user_id.text.toString())
            startActivity(intent)
        }
    }
}