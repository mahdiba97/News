package com.mahdiba97.news.feature_foundation.data.remote.dto

import com.mahdiba97.news.feature_foundation.domain.model.News

data class NewsDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
) {
    fun toNews() = News(
        articles.map { it.toArticle() }, status, totalResults
    )
}