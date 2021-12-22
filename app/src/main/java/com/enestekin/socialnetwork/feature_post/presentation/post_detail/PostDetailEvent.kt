package com.enestekin.socialnetwork.feature_post.presentation.post_detail

sealed class PostDetailEvent {

    object LikedPost: PostDetailEvent()
    object Comment : PostDetailEvent()
    data class LikeComment(val commentId: String): PostDetailEvent()
    object SharePost: PostDetailEvent()
    data class EnteredComment(val comment: String): PostDetailEvent()
}