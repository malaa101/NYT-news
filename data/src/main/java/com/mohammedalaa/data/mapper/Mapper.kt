package com.mohammedalaa.data.mapper

import com.mohammedalaa.data.model.MediaEntity
import com.mohammedalaa.data.model.MediaMetadataEntity
import com.mohammedalaa.data.model.NewsResponseEntity
import com.mohammedalaa.data.model.NewsEntity
import com.mohammedalaa.domain.model.MediaModel
import com.mohammedalaa.domain.model.MediaMetadataModel
import com.mohammedalaa.domain.model.NewsResponseModel
import com.mohammedalaa.domain.model.NewsModel


fun NewsResponseEntity.toDomain(): NewsResponseModel = NewsResponseModel(
    copyright=copyright,
    numResults=numResults,
    results = results.toNewsDomain(),
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
    mediaMetadata = mediaMetadata.toMediaMetadataDomain(),
    subtype = subtype,
    type = type,
    copyright = copyright
)

fun NewsEntity.toDomain(): NewsModel= NewsModel(
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
    media = media.toMediaDomain(),
    etaId = etaId,
    nytdsection = nytdsection,
    adxKeywords = adxKeywords,
    source = source,
    type = type,
    updated = updated,
)

fun List<NewsEntity>.toNewsDomain(): List<NewsModel> = map { it.toDomain() }
fun List<MediaMetadataEntity>.toMediaMetadataDomain(): List<MediaMetadataModel> = map { it.toDomain() }
fun List<MediaEntity>.toMediaDomain(): List<MediaModel> = map { it.toDomain() }

