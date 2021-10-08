package com.enestekin.socialnetwork.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.enestekin.socialnetwork.R
import com.enestekin.socialnetwork.presentation.util.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {

    val scale = remember {
        Animatable(0f)
    }

    // making animation  bigger then smaller
    val overshootInterpolator = remember {
        OvershootInterpolator(3f)
    }

    // When boolean is changed coroutine canceled and relaunch
    LaunchedEffect(key1 = true) {

        scale.animateTo(
            targetValue = 2f,
            animationSpec =  tween(
                durationMillis = 3000,
                easing =  {
                    overshootInterpolator.getInterpolation(it)
                }
            )
                )

            delay(Constants.SPLASH_SCREEN_DURATION)
        navController.navigate(Screen.LoginScreen.route){
            navController.popBackStack() // clear backstack
            popUpTo(Screen.SplashScreen.route)
        }

    }
    
    Box(
        modifier =Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription ="Logo",
            modifier = Modifier.scale(scale.value)
        )

    }
    
}