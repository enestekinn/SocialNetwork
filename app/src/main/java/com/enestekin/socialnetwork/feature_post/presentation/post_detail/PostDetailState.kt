package com.enestekin.socialnetwork.feature_post.presentation.post_detail

import com.enestekin.socialnetwork.core.domain.models.Comment
import com.enestekin.socialnetwork.core.domain.models.Post

data class PostDetailState(
    val post: Post? = null,
    val comments: List<Comment> = emptyList(),
    val isLoadingPost: Boolean = false,
    val isLoadingComments: Boolean = false
)
