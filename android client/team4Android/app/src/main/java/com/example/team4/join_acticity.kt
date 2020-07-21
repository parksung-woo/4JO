package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*

class join_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        //액션바 대신 툴바사용
        setSupportActionBar(toolbar)




        //뒤로가기 버튼
//        button_back.setOnClickListener{
//            val intent = Intent(this, login_activity::class.java) //LIstPageActivity로 이동
//            startActivity(intent)
//        }

        //회원가입 완료 버튼
        button_set.setOnClickListener {
            Toast.makeText(this, "회원가입을 성공했습니다."
                , Toast.LENGTH_SHORT).show()
            val intent = Intent(this, login_activity::class.java) //LIstPageActivity로 이동
            startActivity(intent)
        }


        }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

}