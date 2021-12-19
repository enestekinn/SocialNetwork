package com.enestekin.socialnetwork.core.domain.models

data class UserItem(
    val userId: String,
    val username: String,
    val profilePicture: String,
    val bio: String,
    val isFollowing: Boolean
)