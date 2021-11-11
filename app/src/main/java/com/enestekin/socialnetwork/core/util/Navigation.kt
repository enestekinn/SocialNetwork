package com.enestekin.socialnetwork.core.util

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enestekin.socialnetwork.MainFeedScreen
import com.enestekin.socialnetwork.core.domain.models.Post
import com.enestekin.socialnetwork.feature_activity.presentation.activity.ActivityScreen
import com.enestekin.socialnetwork.feature_auth.presentation.login.LoginScreen
import com.enestekin.socialnetwork.feature_auth.presentation.register.RegisterScreen
import com.enestekin.socialnetwork.feature_chat.presentation.ChatScreen
import com.enestekin.socialnetwork.feature_post.presentation.create_post.CreatePostScreen
import com.enestekin.socialnetwork.feature_post.presentation.post_detail.PostDetailScreen
import com.enestekin.socialnetwork.feature_profile.edit_profile.EditProfileScreen
import com.enestekin.socialnetwork.feature_profile.presentation.profile.ProfileScreen
import com.enestekin.socialnetwork.feature_profile.search.SearchScreen
import com.enestekin.socialnetwork.feature_splash.presentation.SplashScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)

        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(
                navController = navController,
            scaffoldState= scaffoldState
            )
        }

        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.EditProfileScreen.route) {
            EditProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(navController = navController)
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route) {
            PostDetailScreen(
                navController = navController,
                post = Post(
                    username = "enestekin",
                    imageUrl = "",
                    profilePictureUrl = "",
                    description = "Lorem  Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı bili nmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyen \n" +
                            "Lorem  Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı bili nmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyenbilinmeyen",
                    likeCount = 17,
                    commentCount = 7
                ),

                )
        }



    }

}