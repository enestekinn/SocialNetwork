package com.enestekin.socialnetwork.feature_post.presentation.main_feed

import com.enestekin.socialnetwork.core.domain.models.Post

data class MainFeedState(
    val posts: List<Post>,
    val isLoading: Boolean = false,
    val page: Int = 0,
)
