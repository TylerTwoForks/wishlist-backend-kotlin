package com.edmondsinc.wishlist.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDateTime

class ArticleRes (
    var status:String,
    var totalResults:String,
    var articles:List<ArticleDetail>
){

    @JsonIgnoreProperties("source")
    class ArticleDetail(
        var author:String?,
        var title: String?,
        var description: String?,
        var url:String?,
        var urlToImage:String?,
        var publishedAt:LocalDateTime?,
        var content:String?
    ){
        override fun toString(): String {
            return "ArticleDetail(author='$author', title='$title', description='$description', url='$url', urlToImage='$urlToImage', publishedAt=$publishedAt, content='$content')"
        }
    }

    override fun toString(): String {
        return "ArticleRes(status='$status', totalResults='$totalResults', articles=${articles})"
    }


}