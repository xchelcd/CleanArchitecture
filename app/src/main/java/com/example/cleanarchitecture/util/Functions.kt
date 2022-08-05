package com.example.cleanarchitecture.util


fun interface Callback {
    operator fun invoke()
}

fun interface CallbackWithText {
    operator fun invoke(s: String)
}

fun interface CallbackWithObj {
    operator fun invoke(item: Any)
}