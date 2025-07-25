package com.mike.tripzy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.mike.tripzy.ui.screens.HomeScreen
import com.mike.tripzy.ui.screens.SignInScreen
import com.mike.tripzy.ui.screens.SignUpScreen
import com.mike.tripzy.ui.screens.SplashScreen
import com.mike.tripzy.ui.theme.TripzyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TripzyTheme {
                val navController = rememberNavController()
                var showSplashScreen by remember { mutableStateOf(true) }

                if (showSplashScreen) {
                    SplashScreen(onTimeout = { showSplashScreen = false })
                } else {
                    val startDestination = if (FirebaseAuth.getInstance().currentUser != null) "home" else "signIn"
                    NavHost(navController = navController, startDestination = startDestination) {
                        composable("signIn") {
                            SignInScreen()
                        }
                        composable("signUp") {
                            SignUpScreen()
                        }
                        composable("home") {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}
