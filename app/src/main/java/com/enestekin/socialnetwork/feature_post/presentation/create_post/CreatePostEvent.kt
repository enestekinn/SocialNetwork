package com.enestekin.socialnetwork.feature_post.presentation.create_post

import android.net.Uri

sealed class CreatePostEvent {
    data class EnterDescription(val value: String): CreatePostEvent()
    data class PickedImage(val uri: Uri?): CreatePostEvent()
    object PostImage: CreatePostEvent()
}