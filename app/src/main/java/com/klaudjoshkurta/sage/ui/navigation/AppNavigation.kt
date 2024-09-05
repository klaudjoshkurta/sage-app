package com.klaudjoshkurta.sage.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.klaudjoshkurta.sage.ui.home.HomeScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: Screen = Screen.Home
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen()
        }
    }
}