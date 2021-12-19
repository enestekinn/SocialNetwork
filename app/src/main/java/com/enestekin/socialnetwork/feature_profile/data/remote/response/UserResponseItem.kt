package com.enestekin.socialnetwork.feature_profile.data.remote.response

import com.enestekin.socialnetwork.core.domain.data.dto.response.UserItemDto


data class UserResponseItem(
    val userId: String,
    val username: String,
    val profilePictureUrl: String,
    val bio: String,
    val isFollowing: Boolean
){
    fun toUserItem(): UserItemDto {
        return UserItemDto(
            userId = userId,
            username = username,
            profilePictureUrl = profilePictureUrl,
            bio = bio,
            isFollowing = isFollowing

        )
    }
}