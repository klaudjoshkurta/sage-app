package com.klaudjoshkurta.sage.ui.navigation

import android.content.SharedPreferences
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.klaudjoshkurta.sage.ui.home.HomeScreen
import com.klaudjoshkurta.sage.ui.onboarding.OnBoardingScreen

sealed class Screen(val route: String) {
    data object Onboarding : Screen("onboarding")
    data object Home : Screen("home")
}

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: Screen = Screen.Onboarding,
    sharedPreferences: SharedPreferences
) {

    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {

        composable(
            route = Screen.Onboarding.route
        ) {
            OnBoardingScreen(
                navigateToHome = {
                    sharedPreferences.edit().putBoolean("onboarding_complete", true).apply()
                    navController.navigate(Screen.Home.route)
                }
            )
        }

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                sharedPreferences = sharedPreferences
            )
        }
    }
}