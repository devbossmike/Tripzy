package com.mike.tripzy.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
            name = "Search",
            route = "search",
            icon = Icons.Filled.Search
        ),
        BottomNavItem(
            name = "Settings",
            route = "settings",
            icon = Icons.Filled.Settings
        )
    )
}