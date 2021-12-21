package com.enestekin.socialnetwork.feature_post.domain.use_case

import com.enestekin.socialnetwork.core.domain.models.Comment
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository

class GetCommentsForPostUseCase(
    private val repository: PostRepository
) {


    suspend operator fun invoke(postId: String): Resource<List<Comment>>{
        return repository.getCommentsForPost(postId)
    }
}