package com.enestekin.socialnetwork.presentation.domain.models

import com.enestekin.socialnetwork.presentation.domain.util.ActivityAction

data class Activity(
   val  username: String,
   val actionType: ActivityAction,
    val formattedTime: String,
)
