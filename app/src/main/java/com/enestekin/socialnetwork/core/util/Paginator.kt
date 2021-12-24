package com.enestekin.socialnetwork.core.util

interface Paginator<T> {

    suspend fun loadNextItems()
}