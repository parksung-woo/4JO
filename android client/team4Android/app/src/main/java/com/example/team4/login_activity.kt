package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder

class login_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //로그인 버튼 클릭
        button_login.setOnClickListener{
            val inputId = login_id.text.toString()
            val inputPw = login_password.text.toString()

//            if(inputId == "admin" && inputPw == "1234"){ //로그인이 성공했을 경우
//                val intent = Intent(this,catagory_activity ::class.java)
//                startActivity(intent)
//            }
//            else Toast.makeText(this, "아이디와 비밀번호를 확인해주세요"
//                , Toast.LENGTH_SHORT).show()

            var tmp: String = ""
            Log.i("testLog", "loginclick id:${login_id.text} pw:${login_password.text}")
            Thread() {
                tmp = UpdateMainLog1("${login_id.text}", "${login_password.text}")
                var tmps: List<String> = tmp.split("@");
                runOnUiThread {
                    Log.i("testLog", "loginclick : ${tmp}")
                    if ("${tmp}".equals("로그인 결과 : 0")) {
                        Log.i("testLog", "로그인실패")
                        Toast.makeText(this, "로그인 실패.", Toast.LENGTH_SHORT).show()
                    } else if ("${tmp}".equals("로그인 결과 : 1")) {
                        Log.i("testLog", "로그인성공")
                        val intent = Intent(this, catagory_activity::class.java)
                        startActivity(intent)
                    }
                }
            }.start()
        }
        
        //회원가입 버튼 클릭
        button_register.setOnClickListener{
            val intent = Intent(this,join_acticity ::class.java)
            startActivity(intent)
        }

    }
}

fun UpdateMainLog1(member_id:String,member_password:String):String{
    val url = URL("http://192.168.0.100:8383/androidLogin?member_id=${member_id}&member_password=${member_password}")
    val conn = url.openConnection() as HttpURLConnection // casting
    Log.i("testLog", "conn.responseCode : ${conn.responseCode}")
    if(conn.responseCode == 200){
        val txt = url.readText()
        /*val arr = JSONArray(txt)
        var item = arr*/
        return "${txt}"
    } else return "null"
}
