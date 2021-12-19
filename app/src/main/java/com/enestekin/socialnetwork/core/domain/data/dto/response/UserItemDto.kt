package com.enestekin.socialnetwork.core.domain.data.dto.response

import com.enestekin.socialnetwork.core.domain.models.UserItem

data class UserItemDto(
    val userId: String,
    val username: String,
    val profilePictureUrl: String,
    val bio: String,
    val isFollowing: Boolean
) {
    fun toUserItem(): UserItem {
        return UserItem(
            userId = userId,
            username = username,
            profilePicture = profilePictureUrl,
            bio= bio,
            isFollowing = isFollowing

        )
    }
}