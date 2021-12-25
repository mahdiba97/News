package com.mahdiba97.news.feature_foundation.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahdiba97.news.feature_foundation.data.remote.NewsAPI
import com.mahdiba97.news.feature_foundation.data.remote.ServiceBuilder
import com.mahdiba97.news.feature_foundation.domain.model.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val api = ServiceBuilder.buildService(NewsAPI::class.java, NewsAPI.BASE_RUL)

    //    private val _headLine = mutableStateOf<News>()
//    val headLine: State<News> = _headLine
    var counter = flow {
        val startValue = 10
        var current = startValue
        emit(startValue)
        while (current > 0) {
            delay(1000L)
            current--
            emit(current)
        }
    }
    var timer = (1..10).asFlow().cancellable()

    init {
        timer.onEach {
            delay(1000L)
        }.launchIn(viewModelScope)
    }

    private val _line = MutableSharedFlow<News>()
    val line = _line.asSharedFlow()
    fun searchNews(q: String) {
        val hashMap = HashMap<String, String>()
        hashMap["apikey"] = NewsAPI.API_KEY
        hashMap["from"] = "2021-12-15"
        hashMap["to"] = "2021-12-15"
        hashMap["sortBy"] = "popularity"
        hashMap["q"] = q
        viewModelScope.launch {
            val news = api.getSearchNews(hashMap).toNews()
            _line.emit(news)
        }
    }


    fun topHeadline(category: String) {

        val hashMap = HashMap<String, String>()
        hashMap["apikey"] = NewsAPI.API_KEY
        hashMap["category"] = category
        viewModelScope.launch {
            _line.emit(api.getTopNews(hashMap).toNews())
        }
    }
}
