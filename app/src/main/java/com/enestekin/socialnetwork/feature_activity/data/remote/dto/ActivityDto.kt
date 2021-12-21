package com.enestekin.socialnetwork.feature_activity.data.remote.dto

import com.enestekin.socialnetwork.core.domain.models.Activity
import com.enestekin.socialnetwork.feature_activity.domain.ActivityType
import java.text.SimpleDateFormat
import java.util.*


data class ActivityDto(
    val timeStamp: Long,
    val userId: String,
    val parentId: String,
    val type: Int,
    val username: String,
    val id: String
) {
    fun toActivity(): Activity  {
        return Activity(
            userId = userId,
            parentId = parentId,
            username = username,
            activityType = when(type){
                ActivityType.FollowedUser.type -> ActivityType.FollowedUser
                ActivityType.LikedPost.type -> ActivityType.LikedPost
                ActivityType.LikedComment.type -> ActivityType.LikedComment
                ActivityType.CommentedOnPost.type -> ActivityType.CommentedOnPost
                else -> ActivityType.FollowedUser
            },
            // put here what is dateformat like
            formattedTime = SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault()).run {
                format(timeStamp)
            }
        )
    }
}
