package com.example.mynewsapplication

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class NewsAdapter: RecyclerView.Adapter<NewsViewHolder>() {

    private val newsArray:ArrayList<News> = ArrayList();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        val newsView = NewsViewHolder(view)
        return newsView
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.text = newsArray[position].title
        holder.author.text = newsArray[position].author
        Glide.with(holder.imageView.context).load(newsArray[position].imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return newsArray.size
    }

    fun notifyItemChanged(updatedItem: ArrayList<News>){
        newsArray.clear()
        newsArray.addAll(updatedItem)
    }


}

interface NewsClicked {
    fun onItemClicked(item:News)
}

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.title)
    val author: TextView = itemView.findViewById(R.id.author)
}