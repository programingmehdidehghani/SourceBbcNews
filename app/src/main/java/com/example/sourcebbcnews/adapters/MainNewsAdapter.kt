package com.example.sourcebbcnews.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sourcebbcnews.R
import com.example.sourcebbcnews.models.Article
import com.example.sourcebbcnews.ui.NewsContentActivity
import kotlinx.android.synthetic.main.items_headline.view.*

class MainNewsAdapter : RecyclerView.Adapter<MainNewsAdapter.ArticleViewHolder>() {

    private var context: Context? = null


    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_headline,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Article) -> Unit)? = null


    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(article.urlToImage).into(iv_picture_news_in_item_headline)
            tv_names_provider_news_in_items_headline.text = article.source?.name
            tv_title_news_in_items_headline.text = article.title
            tv_date_news_in_items_headline.text = article.publishedAt
            tv_title_news_in_items_headline.setOnClickListener {
                val intent = Intent(context, NewsContentActivity::class.java)
                intent.putExtra("keyString", article.publishedAt)
                context.startActivity(intent)
            }
        }
    }


}