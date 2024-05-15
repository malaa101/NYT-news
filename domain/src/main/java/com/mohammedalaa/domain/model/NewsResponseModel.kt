package com.mohammedalaa.domain.model


data class NewsResponseModel(
    val copyright: String, // Copyright (c) 2024 The New York Times Company.  All Rights Reserved.
    val numResults: Int, // 20
    val results: List<ResultModel>,
    val status: String // OK
)