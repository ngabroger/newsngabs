package com.ngabroger.newsngabs.presentation.screen.news

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ngabroger.newsngabs.data.model.ArticlesItem
import com.ngabroger.newsngabs.presentation.component.NewsCard
import com.ngabroger.newsngabs.presentation.viewmodel.NewsViewModelImpl
import com.ngabroger.newsngabs.utils.Result
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen(viewModel : NewsViewModelImpl = koinViewModel()) {
val newsState = viewModel.news.collectAsState()
    Column(Modifier.fillMaxSize()){


        when(val state = newsState.value){
            is Result.Success<List<ArticlesItem>> ->{
                Log.d("NewsScreen", "NewsScreen: ${state.data}")
                LazyColumn {
                    items(state.data){
                        NewsCard(article = it, onClick = {
                            Log.d("NewsScreen", "NewsScreen: ${it.url}")
                        })
                    }
                }
            }

            is Result.Loading ->{
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,



                ){
                    CircularProgressIndicator()
                }

            }
            is Result.Error ->{
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Text("Error")
                }

            }



        }
    }


}