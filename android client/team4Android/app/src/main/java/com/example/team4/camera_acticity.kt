package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_graph.*


class camera_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        button_back.setOnClickListener {
            val intent = Intent(this, management_acticity::class.java)
            startActivity(intent)
        }
        button14.setOnClickListener {
            val intent = Intent(this, catagory_acticity::class.java)
            startActivity(intent)
        }
    }
}