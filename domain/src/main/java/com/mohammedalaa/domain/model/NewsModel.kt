package com.mohammedalaa.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class NewsModel(
    val `abstract`: String?, // She has never accused Donald Trump of anything but a payoff, but their encounter sounds a lot murkier than before.
    val adxKeywords: String?, // Sex;New York State Criminal Case Against Trump (71543-23);Trump, Donald J;Clifford, Stephanie (1979- )
    val assetId: Long?, // 100000009456431
    val byline: String?, // By Jessica Bennett
    val desFacet: List<String>?,
    val etaId: Int?, // 0
    val geoFacet: List<String>?,
    val id: Long?, // 100000009456431
    val media: List<MediaModel>?,
    val nytdsection: String?, // opinion
    val orgFacet: List<String>?,
    val perFacet: List<String>?,
    val publishedDate: String?, // 2024-05-07
    val section: String?, // Opinion
    val source: String?, // New York Times
    val subsection: String?,
    val title: String?, // The Darker Side of Stormy Daniels’s Testimony
    val type: String?, // Article
    val updated: String?, // 2024-05-08 10:02:44
    val uri: String?, // nyt://article/378eef77-ccea-56fc-a84f-58fc843af022
    val url: String? // https://www.nytimes.com/2024/05/07/opinion/stormy-daniels-trump-trial.html
): Parcelable