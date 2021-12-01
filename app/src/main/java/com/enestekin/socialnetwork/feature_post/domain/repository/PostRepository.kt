package com.enestekin.socialnetwork.feature_post.domain.repository

import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.core.util.Constants
import com.enestekin.socialnetwork.core.util.Resource

interface PostRepository {

    suspend fun getPostsForFollows(
        page: Int = 0,
        pageSize: Int = Constants.PAGE_SIZE_POSTS
    ): Resource<List<Post>>
}