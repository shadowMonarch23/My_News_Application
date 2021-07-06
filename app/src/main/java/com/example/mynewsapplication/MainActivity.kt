package com.example.mynewsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()
        var intent = Intent(this, SelectTopic::class.java)
        val india:Button = findViewById<Button>(R.id.`in`)
        india.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=in")
            startActivity(intent)
        }
        val us:Button = findViewById<Button>(R.id.us)
        us.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=us")
            startActivity(intent)
        }
        val aus:Button = findViewById<Button>(R.id.aus)
        aus.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=au")
            startActivity(intent)
        }
        val uk:Button = findViewById<Button>(R.id.uk)
        uk.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=gb")
            startActivity(intent)
        }
        val can:Button = findViewById<Button>(R.id.dk)
        can.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=ca")
            startActivity(intent)
        }
        val nz:Button = findViewById<Button>(R.id.ge)
        nz.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=nz")
            startActivity(intent)
        }
        val all:Button = findViewById<Button>(R.id.all)
        all.setOnClickListener(){
            intent.putExtra("id","http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en")
            startActivity(intent)
        }
    }

}