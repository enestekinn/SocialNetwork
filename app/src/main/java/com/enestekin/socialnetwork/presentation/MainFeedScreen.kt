package com.enestekin.socialnetwork.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.enestekin.socialnetwork.presentation.components.Post

@Composable
fun MainFeedScreen(
    navController: NavController
) {
    Post(
        post =com.enestekin.socialnetwork.presentation.domain.models.Post(
            username =  "enestekin",
            imageUrl = "",
            profilePictureUrl = "",
            description = "Lorem  Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı bili nmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyen",
            likeCount = 17,
            commentCount = 7
    )
            )

}