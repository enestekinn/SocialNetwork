package com.enestekin.socialnetwork.feature_chat.presentation.domain.model

data class Chat(
    val remoteUsername: String,
    val remoteUserProfileUrl: String,
    val lastMessage:String,
    val lastMessageFormattedTime: String,
)
