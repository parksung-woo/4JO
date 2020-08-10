package com.example.team4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_join.*
import kotlinx.android.synthetic.main.activity_management.*
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class management_activity : AppCompatActivity() {

    private val handler: Handler = Handler()
    private var sensor = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_management)

        Thread(){
            ondo()
        }.start()

        //뒤로가기 버튼
//        button5.setOnClickListener{
//            val intent = Intent(this, catagory_activity::class.java)
//            startActivity(intent)
//        }

        switch2.setOnClickListener{
            if(switch2 != null){
                if (switch2.isChecked){
                    Log.i("testSwitch", switch2.textOn as String)
                    Toast.makeText(this,switch2.textOn as String,Toast.LENGTH_SHORT).show()

                    Thread() {
                        switch(
                            sensor = "1"
                        )
                    }.start()
                    Log.i("test_sensor", sensor)
                }else{
                    Log.i("testSwitch", switch2.textOff as String)
                    Toast.makeText(this,switch2.textOff as String,Toast.LENGTH_SHORT).show()
                    Thread() {
                        switch(
                            sensor = "0"
                        )
                    }.start()
                    Log.i("test_sensor", sensor)
                }
            }

        }

        //그래프버튼
        graphview.setOnClickListener {
            val intent = Intent(this, graph_activity::class.java)
            startActivity(intent)
        }
    }

    fun ondo(){
        //테스트 하려는 디바이스에서 브라우져를 열고
        //http://192.168.0.9/kotlinProject 주소 접속유무를 확인
        //안될시 와이파이 설정할것
        //http://192.168.0.9/kotlinProject/test.json
        val url = URL("http://192.168.0.100:8383/ondoPrint")
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
            var t = ""
            var h = ""
            val arr = JSONArray(txt)
            for(i in 0 until arr.length()){
                val obj:JSONObject = arr.get(i) as JSONObject
                Log.i("testLog","저장된 날짜:${obj["nowDatetime"]}, 온도:${obj["temperature"]}, 습도:${obj["humidity"]}")
                t += "${obj["temperature"]}"
                h += "${obj["humidity"]}"
            }
            handler.post{
                id_temperature.text = t
                id_humidity.text = h
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun switch(sensor:String):String{
        val url = URL("http://192.168.0.100:8383/switch?sensor=${sensor}")
        val conn = url.openConnection() as HttpURLConnection
        Log.i("testSwitchResult","conn.responseCode:${conn.responseCode}, sensor 값:${sensor}")
        return sensor
    }

}