package com.example.cleanarchitecture.data.model

data class Post(
    val id: Int,
    val title: String,
    val body: String,
    val tagList: List<Tag>,
    val price: String
)