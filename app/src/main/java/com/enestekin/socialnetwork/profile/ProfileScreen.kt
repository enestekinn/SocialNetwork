package com.enestekin.socialnetwork.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.components.Post
import com.enestekin.socialnetwork.domain.models.Post
import com.enestekin.socialnetwork.domain.models.User
import com.enestekin.socialnetwork.profile.components.BannerSection
import com.enestekin.socialnetwork.profile.components.ProfileHeaderSection
import com.enestekin.socialnetwork.ui.theme.ProfilePictureSizeLarge
import com.enestekin.socialnetwork.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.ui.theme.SpaceSmall
import com.enestekin.socialnetwork.util.Screen
import com.enestekin.socialnetwork.util.toPx


@Composable
fun ProfileScreen(
    navController: NavController,
    profilePictureSize: Dp = ProfilePictureSizeLarge,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val lazyListState = rememberLazyListState()

    val toolBarState = viewModel.toolbarState.value


    val iconHorizontalCenterLength =
        (LocalConfiguration.current.screenWidthDp.dp.toPx() / 4f -
                (profilePictureSize / 4f).toPx() - SpaceSmall.toPx()) / 2f

    val iconSizeExpanded = 35.dp

    val toolbarHeightCollapsed = 75.dp

    val imageCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - profilePictureSize / 2f) / 2f
    }
    val iconCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - iconSizeExpanded) / 2f
    }

    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = remember {
        bannerHeight + profilePictureSize
    }

    val maxOffset = remember {
        toolbarHeightExpanded - toolbarHeightCollapsed
    }


    val nestedScrollConnection = remember {
        object : NestedScrollConnection { // listen scroll event in children.
            override fun onPreScroll(
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                //available  how many pixels we actually scrolled.
                val delta = available.y
                if (delta > 0f && lazyListState.firstVisibleItemIndex != 0) {
                    return Offset.Zero
                }
                val newOffset = viewModel.toolbarState.value.toolBarOffsetY + delta
                viewModel.setToolbarOffsetY(newOffset.coerceIn(
                    minimumValue = -maxOffset.toPx(),
                    maximumValue = 0f
                ))
                viewModel.setExpandedRatio((viewModel.toolbarState.value.toolBarOffsetY + maxOffset.toPx()) / maxOffset.toPx())
                return Offset.Zero
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = lazyListState
        ) {

            item {
                Spacer(modifier = Modifier.height(toolbarHeightExpanded - profilePictureSize / 2f))
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
                modifier = Modifier
                    .height(
                        (bannerHeight * toolBarState.expandedRatio).coerceIn(
                            minimumValue = toolbarHeightCollapsed,
                            maximumValue = bannerHeight
                        )
                    ),
                leftIconModifier = Modifier
                    .graphicsLayer {
                        translationY =
                            (1f - toolBarState.expandedRatio) * -iconCollapsedOffsetY.toPx()
                        translationX =
                            (1f - toolBarState.expandedRatio) * iconHorizontalCenterLength
                    },
                rightIconModifier = Modifier
                    .graphicsLayer {
                        translationY =
                            (1f - toolBarState.expandedRatio) * -iconCollapsedOffsetY.toPx()
                        translationX =
                            (1f - toolBarState.expandedRatio) * -iconHorizontalCenterLength


                    },

                )
            Image(
                painter = painterResource(id = R.drawable.enes),
                contentDescription = stringResource(id = R.string.profile_image),
                modifier = Modifier
                    .align(CenterHorizontally)
                    // why we use graphicsLayer  not offset. when graphicsLayer used Image is STILL occupied where it defined in compose function
                    .graphicsLayer {
                        translationY =
                            -profilePictureSize.toPx() / 2f - (1f - toolBarState.expandedRatio) *
                                    imageCollapsedOffsetY.toPx()
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0.5f,
                            pivotFractionY = 0f
                        )
                        val scale = 0.5f + viewModel.toolbarState.value.expandedRatio * 0.5f
                        scaleX = scale
                        scaleY = scale

                    }
                    .size(profilePictureSize)
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

