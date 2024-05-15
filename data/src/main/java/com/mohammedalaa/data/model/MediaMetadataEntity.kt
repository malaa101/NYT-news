package com.mohammedalaa.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MediaMetadataEntity(
    val format: String, // Standard Thumbnail
    val height: Int, // 75
    val url: String, // https://static01.nyt.com/images/2024/05/07/opinion/sunday/07Cochran-04/07Cochran-04-thumbStandard.jpg
    val width: Int // 75
)