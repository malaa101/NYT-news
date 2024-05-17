package com.mohammedalaa.newsdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.mohammedalaa.core.base.BaseRoute
import com.mohammedalaa.domain.model.NewsModel

@Composable
fun NewsDetailRoute(
    newsItem: NewsModel?,
    viewModel: NewsDetailViewModel = hiltViewModel(),
) {
    BaseRoute(
        baseViewModel = viewModel,
        shimmerView = {
        }
    ) {
        NewsDetailScreen(newsItem = newsItem)
    }
}

@Composable
private fun NewsDetailScreen(newsItem: NewsModel?) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {

                Image(
                    painter = rememberAsyncImagePainter(model = newsItem?.media?.getOrNull(0)?.mediaMetadata?.getOrNull(0)?.url ?: ""),
                    contentDescription = newsItem?.uri,
                    alignment = Alignment.Center,
                    modifier = Modifier.size(100.dp).clip(CircleShape),
                )
                Column(
                    modifier = Modifier.weight(1F),
                ) {
                    Text(
                        text = newsItem?.title ?: "--",
                        style = MaterialTheme.typography.headlineSmall,
                    )
                    Text(
                        text = newsItem?.abstract ?: "--",
                        style = MaterialTheme.typography.bodyMedium,
                    )


                }
            }


    }
}
