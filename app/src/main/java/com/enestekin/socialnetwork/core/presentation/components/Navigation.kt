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
import androidx.navigation.navArgument
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
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

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    imageLoader: ImageLoader
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
                onLogin = {
                          navController.popBackStack(
                              route = Screen.MainFeedScreen.route,
                              inclusive = false
                          )
                },
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
                scaffoldState = scaffoldState,
                imageLoader = imageLoader


            )

        }
        composable(Screen.ChatScreen.route) {
            ChatScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                imageLoader = imageLoader

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
                onLogout = {
                    navController.navigate(
                        Screen.LoginScreen.route,

                        ) {
                           popUpTo(Screen.LoginScreen.route)
                        if (navController.previousBackStackEntry?.destination?.route
                        == Screen.LoginScreen.route){
                       navController
                        }

                    }
                },
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader

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
                scaffoldState = scaffoldState,
                imageLoader = imageLoader

            )
        }
        composable(Screen.CreatePostScreen.route) {
            CreatePostScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader,
            )
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                imageLoader = imageLoader

            )
        }
        composable(
            route = Screen.PostDetailScreen.route + "/{postId}?shouldShowKeyboard={shouldShowKeyboard}",
            arguments = listOf(
                navArgument(
                    name = "postId"
                ) {
                    type = NavType.StringType
                }

            )
        ) {
            val shouldShowKeyboard = it.arguments?.getBoolean("shouldShowKeyboard") ?: false
            PostDetailScreen(
                scaffoldState = scaffoldState,
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                shouldShowKeyboard = shouldShowKeyboard,
                imageLoader = imageLoader

            )
        }

        composable(
            route = Screen.PersonListScreen.route + "/{parentId}",
            arguments = listOf(
                navArgument("parentId") {
                    type = NavType.StringType
                },
                navArgument("shouldShowKeyboard") {
                    type = NavType.BoolType
                    defaultValue = false
                }
            )
        ) {
            PersonListScreen(
                onNavigateUp = navController::navigateUp,
                onNavigate = navController::navigate,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader

            )
        }
    }
}