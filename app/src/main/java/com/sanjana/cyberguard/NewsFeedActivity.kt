package com.sanjana.cyberguard

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.URL

class NewsFeedActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val newsList = mutableListOf<String>()
    private val apiUrl = "https://newsapi.org/v2/top-headlines?category=technology&apiKey=YOUR_API_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        listView = findViewById(R.id.newsListView)
        fetchNews()
    }

    private fun fetchNews() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = URL(apiUrl).readText()
                val jsonObject = JSONObject(response)
                val articles = jsonObject.getJSONArray("articles")

                for (i in 0 until articles.length()) {
                    val article = articles.getJSONObject(i)
                    val title = article.getString("title")
                    newsList.add(title)
                }

                runOnUiThread {
                    val adapter = ArrayAdapter(this@NewsFeedActivity, android.R.layout.simple_list_item_1, newsList)
                    listView.adapter = adapter
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@NewsFeedActivity, "Failed to fetch news", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
