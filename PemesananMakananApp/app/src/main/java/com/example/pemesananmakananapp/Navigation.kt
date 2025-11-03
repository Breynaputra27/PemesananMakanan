package com.example.pemesananmakananapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.pemesananmakananapp.screens.*


sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Auth : Screen("auth")
    object Login : Screen("login")
    object Register : Screen("register")
    object Main : Screen("main")
    object Home : Screen("home")
    object Order : Screen("order")
    object Profile : Screen("profile")
    object Address : Screen("address")
    object Confirmation : Screen("confirmation")
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()


    val userViewModel: UserViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Splash.route) {


        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.Auth.route) {
            AuthScreen(navController = navController)
        }

        composable(Screen.Login.route) {
            LoginScreen(navController = navController, viewModel = userViewModel)
        }

        composable(Screen.Register.route) {
            RegisterScreen(navController = navController, viewModel = userViewModel)
        }

        composable(Screen.Main.route) {
            MainScreen(rootNavController = navController, viewModel = userViewModel)
        }

        composable(Screen.Address.route) {
            AddressScreen(navController = navController, viewModel = userViewModel)
        }

        composable(Screen.Confirmation.route) {
            ConfirmationScreen(navController = navController, viewModel = userViewModel)
        }
    }
}