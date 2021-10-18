package com.enestekin.socialnetwork.presentation.profile

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.TransformOrigin
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
import com.enestekin.socialnetwork.presentation.util.toDp
import com.enestekin.socialnetwork.presentation.util.toPx


@Composable
fun ProfileScreen(navController: NavController) {

    val lazyListState = rememberLazyListState()

    var toolBarOffsetY by remember {
        mutableStateOf(0f)
    }

val isFirstItemVisible = lazyListState.firstVisibleItemIndex == 0

  println("Scrolled down? $isFirstItemVisible")

    var totalToolbarOffsetY by remember {
        mutableStateOf(0f)
    }

    val iconSizeExpanded = 35.dp
    /*
    val x = 5f
    // this value takes in a specific range
    val y = x.coerceIn(
        minimumValue = 0f,
        maximumValue = 10f
    )  // 5f because of x = 5f

    val z =x.coerceIn(
    minimumValue = 7f,
    maximumValue = 10f
    *
    */   //  z=7f  if x is  15   z= 10f

    val toolbarHeightCollapsed = 75.dp

    var imageCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - ProfilePictureSizeLarge / 2f ) / 2f
    }
    val iconCollapsedOffsetY = remember {
        (toolbarHeightCollapsed - iconSizeExpanded) / 2f
    }

    val bannerHeight = (LocalConfiguration.current.screenWidthDp / 2.5f).dp
    val toolbarHeightExpanded = remember {
        bannerHeight + ProfilePictureSizeLarge
    }

    val maxOffset = remember {
        toolbarHeightExpanded - toolbarHeightCollapsed
    }

    var expandedRatio by remember {
        mutableStateOf(1f)
    }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection { // listen scroll event in children.
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                //available  how many pixels we actually scrolled.
                val delta = available.y
                if (delta > 0f && lazyListState.firstVisibleItemIndex != 0){
                    return Offset.Zero
                }
                val newOffset = toolBarOffsetY + delta
                toolBarOffsetY = newOffset.coerceIn(
                    minimumValue = -maxOffset.toPx(),
                    maximumValue = 0f
                )

                expandedRatio = ((toolBarOffsetY + maxOffset.toPx()) / maxOffset.toPx())


                return Offset.Zero // if Offset is higher than 0 we must scroll  stronger.
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
                Spacer(modifier = Modifier.height(toolbarHeightExpanded - ProfilePictureSizeLarge / 2f))
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
                        (bannerHeight * expandedRatio).coerceIn(
                            minimumValue = toolbarHeightCollapsed,
                            maximumValue = bannerHeight
                        )
                    ),
iconModifier = Modifier
    .graphicsLayer {
        translationY = (1f - expandedRatio ) * -iconCollapsedOffsetY.toPx()
    }
            )
            Image(
                painter = painterResource(id = R.drawable.enes),
                contentDescription = stringResource(id = R.string.profile_image),
                modifier = Modifier
                    .align(CenterHorizontally)
                    // why we use graphicsLayer  not offset. when graphicsLayer used Image is STILL occupied where it defined in compose function
                    .graphicsLayer {
                        translationY =
                            -ProfilePictureSizeLarge.toPx() / 2f - (1f - expandedRatio) * imageCollapsedOffsetY.toPx()
                        transformOrigin = TransformOrigin(
                            pivotFractionX = 0.5f,
                            pivotFractionY = 0f
                        )
                        val scale = 0.5f + expandedRatio * 0.5f
                        scaleX = scale
                        scaleY = scale

                    }
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

