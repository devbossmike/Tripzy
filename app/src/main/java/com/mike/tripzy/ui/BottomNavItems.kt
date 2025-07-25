package com.mike.tripzy.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material.icons.filled.TravelExplore as FilledTravelExplore
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

object BottomNavItems {
    val list = listOf(
        BottomNavItem(
            name = "Home",
            route = "home",
            icon = Icons.Filled.Home
        ),
        BottomNavItem(
            name = "Explore",
            route = "explore",
            icon = Icons.Filled.FilledTravelExplore
        ),
        BottomNavItem(
            name = "Trips",
            route = "trips",
            icon = Icons.Filled.Settings
        ),
        BottomNavItem(
            name = "Favorites",
            route = "favorites",
            icon = Icons.Filled.Favorite
        )
    )
}