package com.enestekin.socialnetwork.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.enestekin.socialnetwork.presentation.ui.theme.SocialNetworkTheme
import com.enestekin.socialnetwork.presentation.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialNetworkTheme {
                // A surface container using the 'background' color from the theme
                Surface(
color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {

                    Navigation()
                }
            }
        }
    }
}

