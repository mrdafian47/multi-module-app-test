package com.dafian.android.feature_todo.entity

import com.fasterxml.jackson.annotation.JsonProperty

data class Todo(
    @JsonProperty("userId") val userId: Int,
    @JsonProperty("id") val id: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("completed") val completed: Boolean
)