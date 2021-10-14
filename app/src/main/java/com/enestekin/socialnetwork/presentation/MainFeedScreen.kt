package com.enestekin.socialnetwork.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enestekin.socialnetwork.presentation.components.Post
import com.enestekin.socialnetwork.presentation.components.StandardScaffold

@Composable
fun MainFeedScreen(
    navController: NavController
) {

    StandardScaffold(
        navController = navController,
        modifier = Modifier.fillMaxSize()
    ){
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




}