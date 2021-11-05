package com.enestekin.socialnetwork.util

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enestekin.socialnetwork.MainFeedScreen
import com.enestekin.socialnetwork.PersonListScreen
import com.enestekin.socialnetwork.presentation.activity.ActivityScreen
import com.enestekin.socialnetwork.presentation.chat.ChatScreen
import com.enestekin.socialnetwork.presentation.create_post.CreatePostScreen
import com.enestekin.socialnetwork.domain.models.Post
import com.enestekin.socialnetwork.edit_profile.EditProfileScreen
import com.enestekin.socialnetwork.login.LoginScreen
import com.enestekin.socialnetwork.post_detail.PostDetailScreen
import com.enestekin.socialnetwork.profile.ProfileScreen
import com.enestekin.socialnetwork.register.RegisterScreen
import com.enestekin.socialnetwork.search.SearchScreen
import com.enestekin.socialnetwork.splash.SplashScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController)
 {

    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
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
        composable(Screen.EditProfileScreen.route){
            EditProfileScreen(navController = navController)
        }
        composable(Screen.CreatePostScreen.route){
            CreatePostScreen(navController = navController)
        }

        composable(Screen.SearchScreen.route){
            SearchScreen(navController = navController)
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

        composable(Screen.PersonListScreen.route){
            PersonListScreen(navController = navController)
        }

    }

}