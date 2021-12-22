package com.enestekin.socialnetwork.feature_post.domain.use_case

import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.core.util.UiText
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository

class CreateCommentUseCase(
    private val repository: PostRepository
){
    suspend operator fun invoke(postId: String, comment: String): SimpleResource {
        if (comment.isBlank()){
            return Resource.Error(UiText.StringResource(R.string.error_field_empty))
        }
        if (postId.isBlank()){
            return Resource.Error(UiText.unknownError())
        }
        return repository.createComment(postId, comment)
    }
}
