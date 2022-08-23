package com.example.beautysalon

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var get_started = findViewById<Button>(R.id.get_started)

        get_started.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?) {
                val i = Intent(this@MainActivity, LogIn::class.java)
                startActivity(i)
            }
        })
    }
}