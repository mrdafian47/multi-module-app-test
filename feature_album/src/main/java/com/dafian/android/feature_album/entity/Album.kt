package com.dafian.android.feature_album.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Album(
    @JsonProperty("userId") val userId: String,
    @JsonProperty("id") val id: String,
    @JsonProperty("title") val title: String
)