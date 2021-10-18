package com.enestekin.socialnetwork.presentation.domain.util

sealed class ActivityAction {
    object LikedPost: ActivityAction()
    object CommentedOnPost : ActivityAction()
}
