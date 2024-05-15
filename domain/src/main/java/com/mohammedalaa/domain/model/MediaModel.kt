package com.mohammedalaa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MediaModel(
    val approvedForSyndication: Int, // 1
    val caption: String, // Stormy Daniels.
    val copyright: String, // Josh Cochran
    val mediaMetadata: List<MediaMetadataModel>,
    val subtype: String, // photo
    val type: String // image
):Parcelable