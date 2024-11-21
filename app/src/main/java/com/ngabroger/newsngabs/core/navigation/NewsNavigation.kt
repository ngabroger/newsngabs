package com.ngabroger.newsngabs.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ngabroger.newsngabs.presentation.screen.news.NewsScreen

fun NavGraphBuilder.newsNavigation(navController: NavController){
    composable("news"){
        NewsScreen()
    }
}