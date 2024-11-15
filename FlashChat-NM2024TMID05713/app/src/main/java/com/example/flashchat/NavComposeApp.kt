package com.example.flashchat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.example.flashchat.nav.Action  // Corrected import for Action
import com.example.flashchat.nav.Destination.AuthenticationOption  // Corrected import for AuthenticationOption
import com.example.flashchat.nav.Destination.Home  // Corrected import for Home
import com.example.flashchat.nav.Destination.Login  // Corrected import for Login
import com.example.flashchat.nav.Destination.Register  // Corrected import for Register
import com.example.flashchat.ui.theme.FlashChatTheme  // Corrected import for the theme
import com.example.flashchat.view.AuthenticationView  // Corrected import for AuthenticationView
import com.example.flashchat.view.home.HomeView  // Corrected import for HomeView
import com.example.flashchat.view.login.LoginView  // Corrected import for LoginView
import com.example.flashchat.view.register.RegisterView  // Corrected import for RegisterView

/**
 * The main Navigation composable which will handle all the navigation stack.
 */

@Composable
fun NavComposeApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Action(navController) }
    FlashChatTheme {
        NavHost(
            navController = navController,
            startDestination =
            if (FirebaseAuth.getInstance().currentUser != null)
                Home
            else
                AuthenticationOption
        ) {
            composable(AuthenticationOption) {
                AuthenticationView(
                    register = actions.register,
                    login = actions.login
                )
            }
            composable(Register) {
                RegisterView(
                    home = actions.home,
                    back = actions.navigateBack
                )
            }
            composable(Login) {
                LoginView(
                    home = actions.home,
                    back = actions.navigateBack
                )
            }
            composable(Home) {
                HomeView()
            }
        }
    }
}
