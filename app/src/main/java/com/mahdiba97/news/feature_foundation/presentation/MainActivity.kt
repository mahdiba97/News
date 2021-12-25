package com.mahdiba97.news.feature_foundation.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mahdiba97.news.ui.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsTheme {
                val viewModel = viewModel<HomeViewModel>()
                viewModel.searchNews("tehran")
                val time = viewModel.timer.collectAsState(initial = 10)
                val news = viewModel.line.collectAsState(initial = null)
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = time.value.toString(),
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )
                }
//                Column(modifier = Modifier.fillMaxSize()) {
//                    news.value?.let {
//                        for (i in news.value?.articles!!) {
//                            Text(text = "${i.name}\n ${i.description}", textAlign = TextAlign.Center, fontSize = 20.sp)
//                            Spacer(modifier = Modifier.height(16.dp))
//                        }
//
//                    }
//
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsTheme {
        Greeting("Android")
    }
}