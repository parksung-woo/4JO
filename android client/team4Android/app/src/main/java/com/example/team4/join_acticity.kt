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

        var idCheck: Array<String> = Array(2, { "" })
        val idcheck_fail_response = "중복된 ID"
        val idcheck_sucess_response = "사용가능한 ID"

        button3.setOnClickListener {
            var tmp: String = ""
            Log.i("testLog", "idCheckClick u:${edit_id.text}")
            Thread() {
                tmp = idCheck("${edit_id.text}")
                runOnUiThread {
                    if (tmp.equals(idcheck_sucess_response)) {
                        Toast.makeText(this, tmp, Toast.LENGTH_SHORT).show()
                        idCheck[0] = edit_id.text.toString()
                        idCheck[1] = edit_id.text.toString()
                        Log.i("testLog", "idCheck : ${idCheck[0]}")
                    } else {
                        Toast.makeText(this, tmp, Toast.LENGTH_SHORT).show()
                        idCheck[0] = idcheck_fail_response
                        idCheck[1] = edit_id.text.toString()
                    }
                }
            }.start()
        }

        button_signup.setOnClickListener {
            val id: String = edit_id.text.toString()
            val password: String = edit_password.text.toString()
            val password_confirm: String = edit_password_confirm.text.toString()
            val nickname: String = edit_nickname.text.toString()
            var success: Boolean = (password.equals(password_confirm))

            if ((id.length != 0) and (password.length != 0) and
                (password_confirm.length != 0) and (nickname.length != 0)
            ) {
                if (success) {
                    Log.i("`testLog password -> ", password)
                    Log.i("testLog password2 ->", password_confirm)
                    Toast.makeText(this, "회원가입을 성공했습니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, login_activity::class.java) //LIstPageActivity로 이동
                    startActivity(intent)
                    Thread() {
                        UpdateMainLog(
                            "${edit_id.text.toString()}",
                            "${edit_password.text.toString()}",
                            "${edit_nickname.text.toString()}"
                        )
                    }.start()
                } else {
                    Toast.makeText(this, "비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
                }
            } else if (idCheck[0] == idcheck_fail_response && idCheck[1] == id) {
                Toast.makeText(this, "이미 존재하는 ID입니다.", Toast.LENGTH_SHORT).show()
            } else if (idCheck[0] == "" || idCheck[1] != id) {
                Toast.makeText(this, "ID 중복검사를 하지 않았습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "모든 항목을 입력하세요.", Toast.LENGTH_SHORT).show()
            }
        }

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

        //아이디 정규식 (영문,숫자만 입력가능한 정규식)
        // ex) gasan123 -> Ture
        // ex) 가산123 -> False
        edit_id.filters = arrayOf(InputFilter { source, _, _, _, _, _ ->
            val ps: Pattern =
                Pattern.compile("^[a-zA-Z0-9가\\u318D\\u119E\\u11A2\\u2022\\u2025a\\u00B7\\uFE55]+$")
            if (source == "" || ps.matcher(source).matches()) {
                return@InputFilter source
            }
            Toast.makeText( this, "영문, 숫자만 입력 가능합니다.", Toast.LENGTH_SHORT).show()
            ""
        }, InputFilter.LengthFilter(10))


        //닉네임 정규식 (한글만 입력가능한 정규식)
        // ex) 가산 -> Ture
        // ex) gasan123 -> False
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
    fun UpdateMainLog(member_id:String,member_password:String, member_nickname:String):String{
        val url = URL("http://192.168.0.100:8383/androidInsert?member_id=${member_id}&member_password=${member_password}" +
                "&member_nickname=${member_nickname}")
        val conn = url.openConnection() as HttpURLConnection // casting
        Log.i("testLog", "conn.responseCode : ${conn.responseCode}")
        return "null"
    }


    fun idCheck(member_id:String):String{
        val url = URL("http://192.168.0.100:8383/idCheck?member_id=${member_id}")
        val conn = url.openConnection() as HttpURLConnection
        Log.i("testLog","conn.responseCode:${conn.responseCode}")

        if(conn.responseCode==200){
            println("=== url.readText() ===")
            val txt = url.readText()
            println(txt)
            return "${txt}"
            }
        else return "null"
        }
        //테스트 하려는 디바이스에서 브라우져를 열고
        //http://192.168.0.9/kotlinProject 주소 접속유무를 확인
        //안될시 와이파이 설정할것
        //http://192.168.0.9/kotlinProject/test.json
    }





