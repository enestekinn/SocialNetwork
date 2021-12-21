package com.enestekin.socialnetwork.feature_activity.presentation

import com.enestekin.socialnetwork.core.domain.models.Activity

data class ActivityState(
    val activities: List<Activity> = emptyList(),
    val isLoading: Boolean = false
)
