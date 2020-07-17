package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_managment.*

class management_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        //뒤로가기 버튼
        button5.setOnClickListener{
            val intent = Intent(this, catagory_acticity::class.java)
            startActivity(intent)
        }

        //농장확인버튼 >> 카메라화면
        button4.setOnClickListener {
            val intent = Intent(this, camera_acticity::class.java)
            startActivity(intent)
        }

        //그래프버튼
        button3.setOnClickListener {
            val intent = Intent(this, graph_acticity::class.java)
            startActivity(intent)
        }
    }
}