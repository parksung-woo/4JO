package com.example.team4

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        //로그아웃 버튼 다이얼로그 구현
        button_logout.setOnClickListener { view ->
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("로그아웃을 하시겠습니까?")
            dialog.setMessage("저희 SAFE FARM을 이용해주셔서 감사합니다.")
            dialog.setIcon(R.drawable.icon5)

            fun toast_p() {
                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,login_activity::class.java)
                    startActivity(intent)
            }
            var dialog_listener = object: DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when(which){
                        DialogInterface.BUTTON_POSITIVE ->
                            toast_p()
                    }
                }
            }
            dialog.setPositiveButton("YES",dialog_listener)
            dialog.setNegativeButton("NO",null)
            dialog.show()
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