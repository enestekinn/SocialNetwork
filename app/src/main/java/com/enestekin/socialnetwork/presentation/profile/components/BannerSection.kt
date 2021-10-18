package com.enestekin.socialnetwork.presentation.profile.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.ui.theme.ProfilePictureSizeLarge
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceSmall
import com.enestekin.socialnetwork.presentation.util.toPx

@Composable
fun BannerSection(
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    iconSize: Dp =35.dp,
    onGithubClicked: () -> Unit = {},
    onInstagramClicked: () -> Unit = {},
    onLinkedInClicked: () -> Unit = {},

    ) {


    BoxWithConstraints(
        modifier = modifier
    ) {

        Image(
            painter = painterResource(id = R.drawable.channelart),
            contentDescription = stringResource(id = R.string.banner_image),
            contentScale = ContentScale.Crop,
            modifier = imageModifier
                .fillMaxSize()

        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(  // putting slight background for better view
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black,
                        ),
                        startY = constraints.maxHeight - iconSize.toPx() * 2

                    )
                )
        )
        Row(
            modifier = Modifier
                .height(iconSize)
                .align(Alignment.BottomStart)
                .padding(SpaceSmall)


        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_js_logo),
                contentDescription = "Javascript",
                modifier = Modifier.height(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceMedium))
            Image(
                painter = painterResource(id = R.drawable.ic_csharp_logo),
                contentDescription = "C#",
                modifier = Modifier.height(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceMedium))
            Image(
                painter = painterResource(id = R.drawable.ic_kotlin_logo),
                contentDescription = "Kotlin",
                modifier = Modifier.height(iconSize)
            )
            Spacer(modifier = Modifier.width(SpaceMedium))
        }
        Row(
            modifier = Modifier
                .height(iconSize)
                .align(Alignment.BottomEnd)
                .padding(SpaceSmall)

        ) {
            IconButton(
                onClick = { onGithubClicked },
                modifier = Modifier.size(iconSize)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_github_icon_1),
                    contentDescription = "Github",
                )

            }

            IconButton(
                onClick = onInstagramClicked,
                modifier = Modifier.size(iconSize)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram_glyph_1),
                    contentDescription = "Instagram",
                )

            }
            IconButton(
                onClick = onLinkedInClicked,
                modifier = Modifier.size(iconSize)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_linkedin_icon_1),
                    contentDescription = "LinkedIn",

                    )
            }

        }
    }

}

