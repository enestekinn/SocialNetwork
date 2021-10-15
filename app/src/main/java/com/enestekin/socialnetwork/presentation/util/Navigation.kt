package com.enestekin.socialnetwork.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enestekin.socialnetwork.presentation.MainFeedScreen
import com.enestekin.socialnetwork.presentation.activity.ActivityScreen
import com.enestekin.socialnetwork.presentation.chat.ChatScreen
import com.enestekin.socialnetwork.presentation.create_post.CreatePostScreen
import com.enestekin.socialnetwork.presentation.domain.models.Post
import com.enestekin.socialnetwork.presentation.login.LoginScreen
import com.enestekin.socialnetwork.presentation.post_detail.PostDetailScreen
import com.enestekin.socialnetwork.presentation.profile.ProfileScreen
import com.enestekin.socialnetwork.presentation.register.RegisterScreen
import com.enestekin.socialnetwork.presentation.splash.SplashScreen

@Composable
fun Navigation(navController: NavHostController)
 {

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){

        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }

        composable(Screen.MainFeedScreen.route){
            MainFeedScreen(navController = navController)
        }
        composable(Screen.ChatScreen.route){
            ChatScreen(navController = navController)
        }
        composable(Screen.ActivityScreen.route){
            ActivityScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route){
            CreatePostScreen(navController = navController)
        }
        composable(Screen.PostDetailScreen.route){
            PostDetailScreen(
                navController = navController,
                post =  Post(
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