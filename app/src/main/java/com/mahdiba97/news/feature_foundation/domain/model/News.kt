package com.mahdiba97.news.feature_foundation.domain.model

data class News(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)