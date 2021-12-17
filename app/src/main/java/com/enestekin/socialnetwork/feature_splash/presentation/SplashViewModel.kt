package com.enestekin.socialnetwork.feature_splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enestekin.socialnetwork.core.presentation.util.UiEvent
import com.enestekin.socialnetwork.core.util.Resource
import com.enestekin.socialnetwork.core.util.Screen
import com.enestekin.socialnetwork.feature_auth.domain.use_case.AuthenticateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticateUserCase:  AuthenticateUseCase
): ViewModel(){

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            when(authenticateUserCase()){
                is Resource.Success -> {
                    println("SplashViewModel Resource Success")
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.MainFeedScreen.route)
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.LoginScreen.route)
                    )

                }
            }
        }
    }
}