package com.enestekin.socialnetwork.feature_profile.presentation.search

import com.enestekin.socialnetwork.core.util.Error
import com.enestekin.socialnetwork.core.util.UiText

data class SearchError(
    val message: UiText,

): Error()