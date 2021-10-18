package com.enestekin.socialnetwork.presentation.create_post

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.enestekin.socialnetwork.presentation.util.Screen

@Composable
fun CreatePostScreen(navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Create post screen")
    }

}