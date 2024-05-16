package com.mohammedalaa.designsystem.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mohammedalaa.designsystem.preview.ThemePreviews
import com.mohammedalaa.designsystem.theme.NYTnewsTheme

@Composable
fun NewsItem(
    modifier: Modifier,
    title: String,
    abstract: String,
    urlToImage: String?,
    publishedAt: String,
    onItemClick: () -> Unit,
) {     NewsItemCard(
            modifier = modifier,
            title = title,
            abstract = abstract,
            urlToImage = urlToImage,
            publishedAt = publishedAt,
            onItemClick = { onItemClick() })
}

@Composable
private fun NewsItemCard(
    modifier: Modifier,
    title: String,
    abstract: String,
    urlToImage: String?,
    publishedAt: String,
    onItemClick: () -> Unit) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onItemClick() },
        shape = MaterialTheme.shapes.large,
        colors = if (isSystemInDarkTheme().not()) {
            CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
        } else {
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        },
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = urlToImage),
                contentDescription = title,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape),
            )
            Column(
                modifier = Modifier.weight(1F),
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineSmall,
                )
                Text(
                    text = abstract,
                    style = MaterialTheme.typography.bodySmall,
                )
                Text(text = publishedAt, style = MaterialTheme.typography.labelSmall)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}



@ThemePreviews
@Composable
private fun NewsItemPrev() {
    NYTnewsTheme {
        Surface {
            NewsItem(
                modifier = Modifier,
                title = "Title",
                abstract = "BTC",
                urlToImage = "",
                publishedAt = "100000",
                onItemClick = {},
            )
        }
    }
}

@Composable
private fun ShimmerNewsItem() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(8.dp)
            .clip(RoundedCornerShape(12.dp)),
        shape = MaterialTheme.shapes.large,
        colors = if (isSystemInDarkTheme().not()) {
            CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background)
        } else {
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        },
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .shimmerEffect(),
            )
            Column(
                modifier = Modifier.weight(1F),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(20.dp)
                        .shimmerEffect(),
                )
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(20.dp)
                        .shimmerEffect(),
                )

            }
        }
    }
}


@Composable
fun ShimmerNewsList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(20) {
            ShimmerNewsItem()
        }
    }
}

@ThemePreviews
@Composable
private fun ShimmerMarketItemPrev() {
    NYTnewsTheme {
        Surface {
            ShimmerNewsItem()
        }
    }
}
