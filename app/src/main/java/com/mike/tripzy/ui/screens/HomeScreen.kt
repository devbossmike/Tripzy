package com.mike.tripzy.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Scaffold
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.vector.ImageVector
import com.mike.tripzy.ui.BottomNavItems
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun HomeScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomAppBarComponent(navController) }
    ) { paddingValues ->
        NavHostComponent(navController = navController, modifier = Modifier.padding(paddingValues))
    }
}

@Composable
fun BottomAppBarComponent(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    val items = BottomNavItems.list

    BottomAppBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = selectedItem == index,
                onClick = { selectedItem = index
                          navController.navigate(item.route) }
            )
        }
    }
}

@Composable
fun NavHostComponent(navController: NavController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = "home", modifier = modifier) {
        composable("home") {
            Text(text = "Home Screen")
        }
        composable("search") {
            Text(text = "Search Screen")
        }
        composable("settings") {
            Text(text = "Settings Screen")
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}