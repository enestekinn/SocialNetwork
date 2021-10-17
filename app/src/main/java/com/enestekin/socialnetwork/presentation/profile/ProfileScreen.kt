package com.enestekin.socialnetwork.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.components.Post
import com.enestekin.socialnetwork.presentation.domain.models.Post
import com.enestekin.socialnetwork.presentation.domain.models.User
import com.enestekin.socialnetwork.presentation.profile.components.BannerSection
import com.enestekin.socialnetwork.presentation.profile.components.ProfileHeaderSection
import com.enestekin.socialnetwork.presentation.ui.theme.ProfilePictureSizeLarge
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.util.Screen


@Composable
fun ProfileScreen(navController: NavController) {

    val lazyList = rememberLazyListState()
    var toolBarOffsetY by remember {
        mutableStateOf(0f)
    }

    val toolbarHeightCollapsed = 56.dp
    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = remember {
        bannerHeight + ProfilePictureSizeLarge
    }


    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = toolBarOffsetY + delta






                return super.onPreScroll(available, source)
            }
        }
    }


//        StandardToolbar(
//            navController = navController,
//            title = {
//                Text(
//                    text = stringResource(id = R.string.your_profile),
//                    fontWeight = FontWeight.Bold,
//                    color = MaterialTheme.colors.onBackground
//                )
//            },
//
//            modifier = Modifier.fillMaxWidth(),
//            showBackArrow = false,
//
//            )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {

            item {
                Spacer(modifier = Modifier.height(toolbarHeightExpanded - ProfilePictureSizeLarge / 2f),)
            }

            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        username = "Enes Tekin",
                        description = "Ne yazayim ki",
                        followerCount = 234,
                        followingCount = 27,
                        postCount = 24
                    )
                )
            }
            items(20) {
                Spacer(
                    modifier = Modifier
                        .height(SpaceMedium)
                    )
                Post(
                    post = Post(
                        username = "enestekin",
                        imageUrl = "",
                        profilePictureUrl = "",
                        description = "Lorem  Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı bili nmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyen",
                        likeCount = 17,
                        commentCount = 7
                    ),
                    showProfileImage = false,
                    onPostClicked = {
                        navController.navigate(Screen.PostDetailScreen.route)
                    },

                )
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)

        ) {
            BannerSection(
                modifier = Modifier.height(bannerHeight)
            )
            Image(
                painter = painterResource(id = R.drawable.enes),
                contentDescription = stringResource(id = R.string.profile_image),
                modifier = Modifier
                    .align(CenterHorizontally)
                    // why we use graphicsLayer  not offset. when graphicsLayer used Image is STILL occupied where it defined in compose function
                    .graphicsLayer {
                        translationY = -ProfilePictureSizeLarge.toPx() / 2f

                    }
                  //  .offset(y = -ProfilePictureSizeLarge / 2f)
                    .size(ProfilePictureSizeLarge)
                    .clip(CircleShape)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface,
                        shape = CircleShape
                    )
            )
        }

    }




}

