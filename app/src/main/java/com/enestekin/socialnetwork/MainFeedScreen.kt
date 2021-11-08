package com.enestekin.socialnetwork

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.enestekin.socialnetwork.core.components.Post
import com.enestekin.socialnetwork.core.components.StandardToolbar
import com.enestekin.socialnetwork.core.util.Screen

@Composable
fun MainFeedScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_feed),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },

            modifier = Modifier.fillMaxWidth(),
            showBackArrow = true,
            navActions = {
                IconButton(
                    onClick = {
                    navController.navigate(Screen.SearchScreen.route)
                }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = MaterialTheme.colors.onBackground
                    )

                }
            }
        )

    }
    Post(
        post = com.enestekin.socialnetwork.domain.models.Post(
            username = "enestekin",
            imageUrl = "",
            profilePictureUrl = "",
            description = "Lorem  Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı bili nmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyen",
            likeCount = 17,
            commentCount = 7
        ),
        onPostClicked = {
            navController.navigate(Screen.PostDetailScreen.route)
        }
    )


}