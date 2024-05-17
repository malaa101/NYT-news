package com.mohammedalaa.navigation

sealed class Destinations(val route: String) {
    data object NewsListScreen : Destinations("news_list_screen")
    data class NewsDetailScreen(val newsItem: String = "newsItem") : Destinations("news_detail_screen")

}
