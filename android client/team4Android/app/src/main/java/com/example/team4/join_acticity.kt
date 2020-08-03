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

class join_acticity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        var tmp: String? = ""
        var infos: List<String>? = null
        if (intent.hasExtra("infoss")) {
            tmp = intent.getStringExtra("infoss")
            infos = tmp?.split("@")
        }

        button_signup.setOnClickListener {
            val id: String = edit_id.text.toString()
            val password: String = edit_password.text.toString()
            val password_confirm: String = edit_password_confirm.text.toString()
            val nickname: String = edit_nickname.text.toString()
            var success: Boolean = (password.equals(password_confirm))
            // password, password_confirm 이 같으면 success ture

            // null값으로 처리하지 않고 length==0 으로 값이 들어왔는지를 확인
            if ((id.length == 0) or (password.length == 0) or
                (password_confirm.length == 0) or (nickname.length == 0)) {
                    Toast.makeText(
                        this, "모든 항목을 입력하세요."
                        , Toast.LENGTH_SHORT
                    ).show()
            } else {
                if (success) {
                    Log.i("`testLog password -> ", password)
                    Log.i("testLog password2 ->", password_confirm)
                    Toast.makeText(
                        this, "회원가입을 성공했습니다."
                        , Toast.LENGTH_SHORT
                    ).show()
                    val intent = Intent(this, login_activity::class.java) //LIstPageActivity로 이동
//                  intent.putExtra("id",user_id.text.toString())
//                  Log.i("testLog user_id -> ", user_id.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this, "비밀번호를 확인하세요."
                        , Toast.LENGTH_SHORT
                    ).show()
                    }
                }
            //            val intent = Intent(this, Login::class.java)
//            if ("${pwd1.text.toString()}".equals("${pwd2.text.toString()}")) {
            Thread() {
                var list: String =
                    UpdateMainLog(
                        "${edit_id.text.toString()}",
                        "${edit_password.text.toString()}",
                        "${edit_nickname.text.toString()}"
                    )
                runOnUiThread {
                    Log.i("testLog", "loginedededed : ${infos?.get(2).toString()}")
                }
            }.start()
        } // end setOnClickListener
    }
    fun UpdateMainLog(member_id:String,member_password:String, member_nickname:String):String{
//        var se=  URLEncoder.encode(member_nickname, "UTF-8");
        val url = URL("http://192.168.0.100:8383/androidInsert?member_id=${member_id}&member_password=${member_password}" +
                "&member_nickname=${member_nickname}")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("testLog", "conn.responseCode : ${conn.responseCode}")
//        if(conn.responseCode == 200){
//            val txt = url.readText()
//            /*val arr = JSONArray(txt)
//            var item = arr*/
//            return "${txt}"
//        } else
            return "null"
    }

}
