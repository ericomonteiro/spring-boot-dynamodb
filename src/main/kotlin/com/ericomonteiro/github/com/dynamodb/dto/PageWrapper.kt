package com.ericomonteiro.github.com.dynamodb.dto

class PageWrapper<out T>(
    val data: List<T>,
    val lastResult: String
) {

    companion object {
        public fun <T> from(data: List<T>, lastResult: String): PageWrapper<T> = PageWrapper(data = data, lastResult)
    }
}
