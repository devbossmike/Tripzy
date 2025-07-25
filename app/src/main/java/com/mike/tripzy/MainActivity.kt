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
import com.google.firebase.FirebaseApp
import androidx.compose.material3.Text // Import Text composable
import androidx.compose.foundation.layout.Box // Import Box composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            TripzyTheme {
                val navController = rememberNavController()
                var showSplashScreen by remember { mutableStateOf(true) }

                if (showSplashScreen) {
                    SplashScreen(onTimeout = { showSplashScreen = false })
                } else {
                    NavHost(navController = navController, startDestination = "splash") {
                        composable("splash") {
                            SplashScreen(onTimeout = {
                                val startDestination = if (FirebaseAuth.getInstance().currentUser != null) "home" else "signIn"
                                navController.navigate(startDestination) {
                                    popUpTo("splash") { inclusive = true }
                                }
                            })
                        }
                        composable("signIn") {
                            SignInScreen(navController = navController)
                        }
                        composable("signUp") {
                            SignUpScreen()
                        }
                        composable("home") {
                            HomeScreen(navController = navController)
                        }
                        composable("trips") {
                            TripsScreen() // Placeholder for Trips screen
                        }
                         composable("favorites") {
                            FavoritesScreen() // Placeholder for Favorites screen
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TripsScreen() { // Placeholder composable
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Trips Screen")
    }
}

@Composable
fun FavoritesScreen() { // Placeholder composable
     Box(modifier = Modifier.fillMaxSize()) {
        Text("Favorites Screen")
    }
}
