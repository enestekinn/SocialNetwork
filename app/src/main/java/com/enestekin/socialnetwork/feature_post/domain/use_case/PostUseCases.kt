package com.enestekin.socialnetwork.feature_post.domain.use_case

import com.enestekin.socialnetwork.core.domain.use_case.ToggleLikeForParentUseCase

data class PostUseCases(
    val getPostsForFollows: GetPostsForFollowsUseCase,
    val createPostUseCase: CreatePostUseCase,
    val getPostDetails: GetPostDetailUseCase,
    val getCommentsForPost: GetCommentsForPostUseCase,
    val createComment: CreateCommentUseCase,
    val toggleLikeForParent: ToggleLikeForParentUseCase,
    val getLikesForParent: GetLikesForParentUseCase
)