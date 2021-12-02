package com.enestekin.socialnetwork.feature_post.domain.use_case

import android.net.Uri
import com.enestekin.socialnetwork.core.util.SimpleResource
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository

class CreatePostUseCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        description: String,
        imageUri: Uri
    ): SimpleResource {
        return repository.createPost(description,imageUri)
    }
}