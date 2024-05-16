package com.mohammedalaa.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsResponseEntity(
    val copyright: String, // Copyright (c) 2024 The New York Times Company.  All Rights Reserved.
    @SerialName("num_results")
    val numResults: Int, // 20
    val results: List<NewsEntity>,
    val status: String // OK
)



