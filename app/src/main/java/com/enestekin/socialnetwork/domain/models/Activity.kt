package com.enestekin.socialnetwork.domain.models

import com.enestekin.socialnetwork.domain.util.ActivityAction

data class Activity(
    val  username: String,
    val actionType: ActivityAction,
    val formattedTime: String,
)
