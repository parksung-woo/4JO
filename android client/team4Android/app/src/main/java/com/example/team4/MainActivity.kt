package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_join.button
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long = 2000 // 1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            // Start your app main activity
            startActivity(Intent(this, login_acticity::class.java))
            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}