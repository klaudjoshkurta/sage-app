package com.klaudjoshkurta.sage

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.klaudjoshkurta.sage.ui.navigation.AppNavigation
import com.klaudjoshkurta.sage.ui.navigation.Screen
import com.klaudjoshkurta.sage.ui.theme.SageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val sharedPreferences = LocalContext.current.getSharedPreferences("sage_preferences", Context.MODE_PRIVATE)

            SageTheme {
                AppNavigation(
                    startDestination = if (sharedPreferences.getBoolean("onboarding_complete", false)) {
                        Screen.Home
                    } else {
                        Screen.Onboarding
                    },
                    sharedPreferences = sharedPreferences
                )
            }
        }
    }
}