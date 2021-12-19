package com.enestekin.socialnetwork.feature_profile.presentation.search

sealed class SearchEvent {
    data class Query(val query: String): SearchEvent()
    data class ToggleFollowState(val userId: String): SearchEvent()
}