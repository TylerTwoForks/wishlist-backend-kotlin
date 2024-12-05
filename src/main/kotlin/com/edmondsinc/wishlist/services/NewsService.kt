package com.edmondsinc.wishlist.services

import com.edmondsinc.wishlist.models.ArticleRes
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Request
import org.springframework.stereotype.Service
import java.io.IOException
import kotlin.time.TimeSource


@Service
class NewsService {
    val timeSource = TimeSource.Monotonic

    private var prefix = "https://newsapi.org/"
    private var apikey = "73bbb91e6473419e8de671bd621f70f9"
    private var postfix = "?country=us&apiKey="
    //api url format: prefix + endpoint + postfix + apikey

    private val client = OkHttpClient()

    fun getTopHeadlines():ArticleRes {
        val start = timeSource.markNow()
        val endpoint = "v2/top-headlines"

        val request = Request.Builder()
            .url(buildUrl(endpoint))
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val jsonString = response.body?.string()

            val articles: ArticleRes = jacksonObjectMapper()
                .findAndRegisterModules()
                .readValue(jsonString!!)
            val end = timeSource.markNow()
            println("elapsed time:: "+(end-start))
            return articles
        }
    }

    fun buildUrl(endpoint:String):String{
        return prefix + endpoint + postfix + apikey
    }

}