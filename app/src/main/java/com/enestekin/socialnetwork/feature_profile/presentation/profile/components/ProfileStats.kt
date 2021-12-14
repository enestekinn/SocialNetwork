package com.enestekin.socialnetwork.feature_profile.presentation.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.core.domain.models.User
import com.enestekin.socialnetwork.core.presentation.ui.theme.SpaceLarge

@Composable
fun ProfileStats(
    user: User,
    modifier: Modifier = Modifier,
    isOwnProfile: Boolean = true,
    isFollowing: Boolean = false,
    onFollowClick: () -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProfileNumber(
            number = user.followerCount,
            text = stringResource(id = R.string.followers)
        )
        Spacer(modifier = Modifier.width(SpaceLarge))

        ProfileNumber(
            number = user.followingCount,
            text = stringResource(id = R.string.following)
        )
        Spacer(modifier = Modifier.width(SpaceLarge))

        ProfileNumber(
            number = user.postCount,
            text = stringResource(id = R.string.posts)
        )
        if (!isOwnProfile) {
            Spacer(modifier = Modifier.width(SpaceLarge))

            Button(
                onClick = onFollowClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor =  if (isFollowing) Color.Red else MaterialTheme.colors.primary
                )
            ) {
                Spacer(modifier = Modifier.height(SpaceLarge))

                Text(
                    text = if (isFollowing){
                        stringResource(id = R.string.unfollow)
                    }else stringResource(id = R.string.follow),
                    color = if (isFollowing) Color.White else MaterialTheme.colors.onPrimary
                        )

            }
        }

    }

}