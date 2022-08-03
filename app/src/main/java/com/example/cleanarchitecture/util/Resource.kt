package com.example.cleanarchitecture.util


sealed class Resource {
    class Successful<T>(val data: T) : Resource()
    class Error(val error: com.example.cleanarchitecture.util.Error) : Resource()
}