package com.enestekin.socialnetwork.feature_splash.presentation

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
import com.enestekin.socialnetwork.core.util.Constants.SPLASH_SCREEN_DURATION
import com.enestekin.socialnetwork.core.util.Screen
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) {

    val scale = remember {
        Animatable(0f)
    }

    // making animation  bigger then smaller
    val overshootInterpolator = remember {
        OvershootInterpolator(0f)
    }

    // When boolean is changed coroutine canceled and relaunch
    LaunchedEffect(key1 = true) {


        withContext(dispatcher){
            scale.animateTo(
                targetValue = 0f,
                animationSpec =  tween(
                    durationMillis = 0,
                    easing =  {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )

            delay(SPLASH_SCREEN_DURATION)
            navController.popBackStack() // clear backstack
            navController.navigate(Screen.LoginScreen.route)
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