package com.edmondsinc.wishlist.controllers

import com.edmondsinc.wishlist.services.NewsService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/news")
class NewsController(
    private val newsService: NewsService
) {

    @GetMapping("/top/headlines")
    fun getNews():ResponseEntity<*>{

        return ResponseEntity(newsService.getTopHeadlines(), HttpStatus.OK)
    }

}