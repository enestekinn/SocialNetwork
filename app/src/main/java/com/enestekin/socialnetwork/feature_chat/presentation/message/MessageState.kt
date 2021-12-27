package com.enestekin.socialnetwork.feature_chat.presentation.message

import com.enestekin.socialnetwork.feature_chat.presentation.domain.model.Message

data class MessageState(
    val messages: List<Message> = emptyList(),
    val isLoading: Boolean = false
)
