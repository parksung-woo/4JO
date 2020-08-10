package com.example.team4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_graph.*


class graph_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        button_graph.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.0.100:8383/graph"))
            startActivity(intent)
        }

    }
}