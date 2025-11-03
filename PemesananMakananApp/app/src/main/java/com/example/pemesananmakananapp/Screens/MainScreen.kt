package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pemesananmakananapp.Screen
import com.example.pemesananmakananapp.UserViewModel

data class BottomNavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val bottomNavItems = listOf(
    BottomNavItem("Home", Icons.Default.Home, Screen.Home.route),
    BottomNavItem("Order", Icons.Default.List, Screen.Order.route),
    BottomNavItem("Profile", Icons.Default.Person, Screen.Profile.route)
)

@Composable
fun MainScreen(rootNavController: NavController, viewModel: UserViewModel) {
    // NavController ini KHUSUS untuk berpindah antar Home, Order, Profile
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            bottomNavController.navigate(item.route) {
                                // Pop up ke start destination untuk hindari back stack besar
                                popUpTo(bottomNavController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = bottomNavController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding) // Terapkan padding dari Scaffold
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    rootNavController = rootNavController,
                    viewModel = viewModel,
                    onFoodClicked = {
                        bottomNavController.navigate(Screen.Order.route) {
                            popUpTo(bottomNavController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
            composable(Screen.Order.route) {
                OrderScreen(rootNavController = rootNavController, viewModel = viewModel)
            }
            composable(Screen.Profile.route) {
                ProfileScreen(rootNavController = rootNavController, viewModel = viewModel)
            }

        }
    }
}