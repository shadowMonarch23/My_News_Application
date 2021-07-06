package com.example.mynewsapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.RequestFuture

class ShowNews : AppCompatActivity(), NewsClicked {

    private lateinit var mAdapter:NewsAdapter
    private lateinit var url:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_news)

        url = intent.getStringExtra("id").toString()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = NewsAdapter()
        recyclerView.adapter = mAdapter
        fetchData()

    }

    private fun fetchData(){
        //val url = "http://api.mediastack.com/v1/news?access_key=6a881e02cc2995fea3433600d744c14d&languages=en&countries=in"

        val json = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener{
                val jsonObjectArray = it.getJSONArray("data")
                var itemList: ArrayList<News> = ArrayList()
                for(i in 0 until jsonObjectArray.length()){
                    val jsonObject = jsonObjectArray.getJSONObject(i)
                    val news:News = News(
                    jsonObject.getString("title"),
                    jsonObject.getString("author"),
                    jsonObject.getString("url"),
                    jsonObject.getString("image")
                    )
                    itemList.add(news)
                }
                mAdapter.notifyItemChanged(itemList)
            },
            Response.ErrorListener{

            }
        )

        MySingleton.getInstance(this).addToRequestQueue(json)
    }

    override fun onItemClicked(item: News) {
        val builder = CustomTabsIntent.Builder();
        val customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(item.url));
    }
}