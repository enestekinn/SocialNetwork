package com.enestekin.socialnetwork.core.presentation

// we put this class core package
data class PagingState<T>(
    val items: List<T> = emptyList(),
    val isLoading: Boolean = false,
    val endReached: Boolean = false
)
