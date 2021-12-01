package com.enestekin.socialnetwork.feature_post.domain.use_case

import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository

class GetPostsForFollowsUserCase(
    private val repository: PostRepository
) {

    suspend operator fun invoke(
        page:Int,
        pageSize:Int
    ): Resource<List<Post>> {
        return repository.getPostsForFollows(page, pageSize)
    }
}