package com.enestekin.socialnetwork.core.domain.models

import com.enestekin.socialnetwork.feature_activity.domain.ActivityAction

data class Activity(
    val  username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)
