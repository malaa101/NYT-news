package com.mohammedalaa.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaEntity(
    @SerialName("approved_for_syndication")
    val approvedForSyndication: Int, // 1
    val caption: String, // Stormy Daniels.
    val copyright: String, // Josh Cochran
    @SerialName("media-metadata")
    val mediaMetadata: List<MediaMetadataEntity>,
    val subtype: String, // photo
    val type: String // image
)