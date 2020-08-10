package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_catagory.*
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_management.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.regex.Pattern

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

        button3.setOnClickListener{

                var id_check = idCheck()
                var id_in = edit_id.text.toString()
                if(id_check.equals(id_in)){
                    Toast.makeText(this, "아이디가 중복됩니다.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "사용 가능합니다.", Toast.LENGTH_SHORT).show()
                }


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


//아이디 정규식
        edit_id.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val ps: Pattern =
                Pattern.compile("^[a-zA-Z0-9가\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
            if (source == "" || ps.matcher(source).matches()) {
                return@InputFilter source
            }
            Toast.makeText( this, "영문, 숫자만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
            ""
        }, InputFilter.LengthFilter(10))


        //닉네임 정규식
        edit_nickname.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val ps: Pattern =
                Pattern.compile("^[9가-힣ㄱ-ㅎㅏ-ㅣ\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
            if (source == "" || ps.matcher(source).matches()) {
                return@InputFilter source
            }
            Toast.makeText( this, "한글만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
            ""
        }, InputFilter.LengthFilter(3))



    }
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


fun idCheck(){
    //테스트 하려는 디바이스에서 브라우져를 열고
    //http://192.168.0.9/kotlinProject 주소 접속유무를 확인
    //안될시 와이파이 설정할것
    //http://192.168.0.9/kotlinProject/test.json
    val url = URL("http://192.168.0.100:8383/id_check")
    val conn = url.openConnection() as HttpURLConnection
    Log.i("testLog","conn.responseCode:${conn.responseCode}")

    if(conn.responseCode==200){
        println("=== url.readText() ===")
        val txt = url.readText()
        println(txt)

        //XML - DOM-문서전체읽은후
        //      SAX-문서를 읽으면서
        //      pull-편리 상수화

        //분석:데이터 파싱
        //JSON [,,]:Array, {"K":"V", , ,}:Object
        var id_check = ""
        val arr = JSONArray(txt)
        for(i in 0 until arr.length()){
            val obj: JSONObject = arr.get(i) as JSONObject
            Log.i("testLog","member_id:${obj["member_id"]}")
            id_check += "${obj["member_id"]}"
        }
    }
}



