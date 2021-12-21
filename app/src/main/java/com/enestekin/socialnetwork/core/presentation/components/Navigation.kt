package com.enestekin.socialnetwork.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.enestekin.socialnetwork.core.util.Screen
import com.enestekin.socialnetwork.feature_activity.presentation.ActivityScreen
import com.enestekin.socialnetwork.feature_auth.presentation.login.LoginScreen
import com.enestekin.socialnetwork.feature_auth.presentation.register.RegisterScreen
import com.enestekin.socialnetwork.feature_chat.presentation.ChatScreen
import com.enestekin.socialnetwork.feature_post.presentation.create_post.CreatePostScreen
import com.enestekin.socialnetwork.feature_post.presentation.main_feed.MainFeedScreen
import com.enestekin.socialnetwork.feature_post.presentation.person_list.PersonListScreen
import com.enestekin.socialnetwork.feature_post.presentation.post_detail.PostDetailScreen
import com.enestekin.socialnetwork.feature_profile.presentation.edit_profile.EditProfileScreen
import com.enestekin.socialnetwork.feature_profile.presentation.profile.ProfileScreen
import com.enestekin.socialnetwork.feature_profile.presentation.search.SearchScreen
import com.enestekin.socialnetwork.feature_splash.presentation.SplashScreen

@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState
) {

    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(Screen.SplashScreen.route) {
            SplashScreen(
                onPopBackStack = navController::popBackStack,
                onNavigate = navController::navigate,
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.MainFeedScreen.route) {
            MainFeedScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )

        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }
        composable(Screen.ActivityScreen.route) {
            ActivityScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }
        composable(
            route = Screen.ProfileScreen.route + "?userId={userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            ProfileScreen(
                userId = it.arguments?.getString("userId"),
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )

        }
        //optional userId
        composable(
            Screen.EditProfileScreen.route + "/{userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                }
            )
        ) {
            EditProfileScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }
        composable(
            route = Screen.PostDetailScreen.route + "/{postId}",
            arguments = listOf(
                navArgument(
                    name = "postId"
                ) {
                    type = NavType.StringType
                }

            )
        ) {
            PostDetailScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate
            )
        }

        composable(Screen.PersonListScreen.route) {
            PersonListScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
            )
        }
    }
}