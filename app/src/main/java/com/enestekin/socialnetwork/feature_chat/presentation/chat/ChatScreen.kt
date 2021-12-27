package com.enestekin.socialnetwork.feature_chat.presentation.chat

import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.enestekin.socialnetwork.core.presentation.ui.theme.SpaceLarge
import com.enestekin.socialnetwork.core.presentation.ui.theme.SpaceMedium
import com.enestekin.socialnetwork.core.util.Screen
import com.enestekin.socialnetwork.feature_chat.presentation.domain.model.Chat

@ExperimentalMaterialApi
@Composable
fun ChatScreen(
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
) {
    val chats = remember {
        listOf(
            Chat(
                remoteUsername = "Enes Tekin",
                remoteUserProfileUrl = "http://192.168.1.5:8001/profile_pictures/69385ce2-0763-4e69-9fcd-9e1e6b4c6e97.png",
                lastMessage = "This is the last message of the chat with Enes",
                lastMessageFormattedTime = "19:07"
            ),
            Chat(
                remoteUsername = "Bekir Tekin",
                remoteUserProfileUrl = "http://192.168.1.5:8001/profile_pictures/69385ce2-0763-4e69-9fcd-9e1e6b4c6e97.png",
                lastMessage = "This is the last message of the chat with Enes",
                lastMessageFormattedTime = "19:07"
            ),
            Chat(
                remoteUsername = "Enes Tekin",
                remoteUserProfileUrl = "http://192.168.1.5:8001/profile_pictures/69385ce2-0763-4e69-9fcd-9e1e6b4c6e97.png",
                lastMessage = "This is the last message of the chat with Enes",
                lastMessageFormattedTime = "19:07"
            ),
            Chat(
                remoteUsername = "Enes Tekin",
                remoteUserProfileUrl = "http://192.168.1.5:8001/profile_pictures/69385ce2-0763-4e69-9fcd-9e1e6b4c6e97.png",
                lastMessage = "This is the last message of the chat with Enes",
                lastMessageFormattedTime = "19:07"
            ),

        )
    }
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(SpaceMedium),
        contentAlignment = Alignment.Center
    ){
LazyColumn(modifier= Modifier.fillMaxSize()){
    items(chats) { chat ->
        ChatItem(
            item = chat,
            imageLoader = imageLoader,
            onItemClick = {
                onNavigate(Screen.MessagesScreen.route)


            }
        )
Spacer(modifier = Modifier.height(SpaceLarge))



    }

}

    }




}