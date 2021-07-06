package com.example.mynewsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SelectTopic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_topic)

        supportActionBar!!.hide()

        var url = intent.getStringExtra("id")
        intent = Intent(this, ShowNews::class.java)

        val gen: Button = findViewById<Button>(R.id.gen)
        gen.setOnClickListener(){
            url += "&categories=general"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val health: Button = findViewById<Button>(R.id.ht)
        health.setOnClickListener(){
            url += "&categories=health"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val sp: Button = findViewById<Button>(R.id.sp)
        sp.setOnClickListener(){
            url += "&categories=sport"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val bns: Button = findViewById<Button>(R.id.bns)
        bns.setOnClickListener(){
            url += "&categories=business"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val sc: Button = findViewById<Button>(R.id.sc)
        sc.setOnClickListener(){
            url += "&categories=science"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val tech: Button = findViewById<Button>(R.id.tech)
        tech.setOnClickListener(){
            url += "&categories=technology"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val en: Button = findViewById<Button>(R.id.ent)
        en.setOnClickListener(){
            url += "&categories=entertainment"
            intent.putExtra("id",url)
            startActivity(intent)
        }
        val all: Button = findViewById<Button>(R.id.all)
        all.setOnClickListener(){
            intent.putExtra("id",url)
            startActivity(intent)
        }
    }
}