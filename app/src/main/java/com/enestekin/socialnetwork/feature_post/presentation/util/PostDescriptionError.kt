package com.enestekin.socialnetwork.feature_post.presentation.util

sealed class PostDescriptionError : Error() {
    object FieldEmpty: PostDescriptionError()
}