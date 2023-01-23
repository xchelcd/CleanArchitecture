package com.example.cleanarchitecture.data.model

private const val TAKE_X_NUMBER = 130

data class Post(
    val id: Int,
    val title: String,
    private val _body: String,
    val tagList: List<Tag>,
    val price: String,
) {

    val body: String
        get() {
            isBodyDisplayed = !isBodyDisplayed
            return _body.take(if (isBodyDisplayed) TAKE_X_NUMBER else _body.length)
        }

    private var isBodyDisplayed = false
}