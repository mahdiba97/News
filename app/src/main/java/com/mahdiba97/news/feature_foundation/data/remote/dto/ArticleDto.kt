package com.mahdiba97.news.feature_foundation.data.remote.dto

import com.mahdiba97.news.feature_foundation.domain.model.Article

data class ArticleDto(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: SourceDto,
    val title: String,
    val url: String,
    val urlToImage: String
) {
    fun toArticle() = Article(
        source.name,
        author,
        content,
        description,
        publishedAt,
        title,
        url,
        urlToImage
    )
}