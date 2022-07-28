package com.example.cleanarchitecture.util

import com.example.cleanarchitecture.data.model.User

fun interface Callback {
    operator fun invoke()
}

fun interface CallbackWithText {
    operator fun invoke(s: String)
}

fun interface CallbackWithUser {
    operator fun invoke(user: User)
}