package com.mohammedalaa.data.mapper

import com.mohammedalaa.data.model.MediaEntity
import com.mohammedalaa.data.model.MediaMetadataEntity
import com.mohammedalaa.data.model.NewsResponseEntity
import com.mohammedalaa.data.model.ResultEntity
import com.mohammedalaa.domain.model.MediaModel
import com.mohammedalaa.domain.model.MediaMetadataModel
import com.mohammedalaa.domain.model.NewsResponseModel
import com.mohammedalaa.domain.model.ResultModel


fun NewsResponseEntity.toDomain(): NewsResponseModel = NewsResponseModel(
    copyright=copyright,
    numResults=numResults,
    results = results.toDomain(),
    status = status
)

fun MediaMetadataEntity.toDomain(): MediaMetadataModel = MediaMetadataModel(
    url = url,
    format = format,
    height = height,
    width = width
)

fun MediaEntity.toDomain(): MediaModel = MediaModel(
    approvedForSyndication = approvedForSyndication,
    caption = caption,
    mediaMetadata = mediaMetadata.toDomain(),
    subtype = subtype,
    type = type,
    copyright = copyright
)

fun ResultEntity.toDomain(): ResultModel= ResultModel(
    abstract = abstract,
    byline = byline,
    desFacet = desFacet,
    geoFacet = geoFacet,
    orgFacet = orgFacet,
    perFacet = perFacet,
    publishedDate = publishedDate,
    section = section,
    subsection = subsection,
    title = title,
    uri = uri,
    url = url,
    id = id ,
    assetId = assetId,
    media = media.toDomain(),
    etaId = etaId,
    nytdsection = nytdsection,
    adxKeywords = adxKeywords,
    column = column,
    source = source,
    type = type,
    updated = updated,
)

fun List<ResultEntity>.toDomain(): List<ResultModel> = map { it.toDomain() }
fun List<MediaMetadataEntity>.toDomain(): List<MediaMetadataModel> = map { it.toDomain() }
fun List<MediaEntity>.toDomain(): List<MediaModel> = map { it.toDomain() }

