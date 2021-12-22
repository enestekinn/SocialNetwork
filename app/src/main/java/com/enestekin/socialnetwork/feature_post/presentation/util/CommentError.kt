package com.enestekin.socialnetwork.feature_post.presentation.util

import com.enestekin.socialnetwork.core.util.Error

sealed class CommentError : Error() {
    object FieldEmpty: CommentError()
}
