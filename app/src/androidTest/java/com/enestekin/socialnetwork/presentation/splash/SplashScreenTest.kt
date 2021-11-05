package com.enestekin.socialnetwork.presentation.splash

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.NavController
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.enestekin.socialnetwork.MainActivity
import com.enestekin.socialnetwork.ui.theme.SocialNetworkTheme
import com.enestekin.socialnetwork.util.Screen
import com.enestekin.socialnetwork.splash.Constants
import com.enestekin.socialnetwork.splash.SplashScreen
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

 /*
    MockTesting object that  does not have real behaviour.
    Track how often each function is called
    Later check popBackstack and navigate func is actually called or not
  */


    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    private val testDispatcher = TestCoroutineDispatcher()


    // This fun don't have implementation
    @RelaxedMockK
    lateinit var navController: NavController


    // This fun is called every single test
    @Before
    fun setUp() {

        MockKAnnotations.init(this)
    }





    @Test
    fun splashScreen_displaysAndDisappears() = runBlockingTest {
        composeTestRule.setContent {
            SocialNetworkTheme {
                SplashScreen(
                    navController = navController,
                dispatcher = testDispatcher
                )
            }
        }

        //  SplashScreen has description named Logo
        composeTestRule.onNodeWithContentDescription(label = "Logo")
            .assertExists()


        advanceTimeBy(Constants.SPLASH_SCREEN_DURATION)

        verify {
           navController.popBackStack()
            navController.navigate(Screen.LoginScreen.route)
       }
    }
}