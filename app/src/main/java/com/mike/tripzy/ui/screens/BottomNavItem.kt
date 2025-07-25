package com.mike.tripzy.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
)

val bottomNavItems = listOf(
    BottomNavItem(
        name = "Home",
        route = "home",
        icon = Icons.Default.Home,
    ),
    BottomNavItem(
        name = "Explore",
        route = "explore",
        icon = Icons.Default.TravelExplore,
    ),
    BottomNavItem(
        name = "Trips",
        route = "trips",
        icon = Icons.Default.LocationOn,
    ),
    BottomNavItem(
        name = "Favorites",
        route = "favorites",
        icon = Icons.Default.Favorite,
    )
)
