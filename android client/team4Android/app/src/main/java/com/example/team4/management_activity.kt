package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_management.*

class management_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_management)

        //뒤로가기 버튼
//        button5.setOnClickListener{
//            val intent = Intent(this, catagory_activity::class.java)
//            startActivity(intent)
//        }

        //농장확인버튼 >> 카메라화면
        cameraview.setOnClickListener {
            val intent = Intent(this, camera_activity::class.java)
            startActivity(intent)
        }

        //그래프버튼
        graphview.setOnClickListener {
            val intent = Intent(this, graph_activity::class.java)
            startActivity(intent)
        }
    }
}