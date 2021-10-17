package com.enestekin.socialnetwork.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.components.Post
import com.enestekin.socialnetwork.presentation.components.StandardToolbar
import com.enestekin.socialnetwork.presentation.domain.models.Post
import com.enestekin.socialnetwork.presentation.domain.models.User
import com.enestekin.socialnetwork.presentation.profile.components.BannerSection
import com.enestekin.socialnetwork.presentation.profile.components.ProfileHeaderSection
import com.enestekin.socialnetwork.presentation.ui.theme.ProfilePictureSizeLarge
import com.enestekin.socialnetwork.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.presentation.util.Screen

@Composable
fun ProfileScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        StandardToolbar(
            navController = navController,
            title = {
                Text(
                    text = stringResource(id = R.string.your_profile),
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground
                )
            },

            modifier = Modifier.fillMaxWidth(),
            showBackArrow = false,

            )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            item {
                BannerSection(
                    modifier = Modifier
                        .aspectRatio(2.5f) //aspectRatio =  width/height
                )
            }
            item {
                ProfileHeaderSection(
                    user = User(
                        profilePictureUrl = "",
                        username  = "Enes Tekin",
                        description =  "Ne yazayim ki",
                        followerCount = 234,
                        followingCount = 27,
                        postCount = 24
                    )
                )
            }
  items(20){
      Spacer(
          modifier = Modifier
              .height(SpaceMedium)
              .offset(y = -ProfilePictureSizeLarge / 2f ),

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
          modifier = Modifier
              .offset(y = -ProfilePictureSizeLarge / 2f),


          )


  }
        }
    }

}