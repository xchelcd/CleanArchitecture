package com.example.cleanarchitecture.data.model

private const val TAKE_X_NUMBER = 130
data class Post(
    val id: Int,
    val title: String,
    private val _body: String,
    val tagList: List<Tag>,
    val price: String,
    var toTake: Int? = TAKE_X_NUMBER
) {

    val body: String
        get() {
            return _body.take(toTake ?: TAKE_X_NUMBER)
        }

}