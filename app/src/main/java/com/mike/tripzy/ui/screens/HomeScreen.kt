package com.mike.tripzy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.mike.tripzy.ui.BottomNavItems

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
    Scaffold(
        bottomBar = { BottomAppBarComponent(navController) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                WelcomeSection()
                Spacer(modifier = Modifier.height(24.dp))
                SearchBar()
                Spacer(modifier = Modifier.height(24.dp))
                QuickActions()
                Spacer(modifier = Modifier.height(24.dp))
                ContentSection("Popular Destinations")
                Spacer(modifier = Modifier.height(24.dp))
                ContentSection("Trending Activities")
            }
        }
    }
}

@Composable
fun WelcomeSection() {
    Column {
        Text("Hello, Mike!", style = MaterialTheme.typography.headlineMedium)
        Text("Where to next?", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text("Search destinations, hotels...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun QuickActions() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { QuickActionButton(Icons.Default.Flight, "Flights") }
        item { QuickActionButton(Icons.Default.Hotel, "Hotels") }
        item { QuickActionButton(Icons.Default.Tour, "Tours") }
        item { QuickActionButton(Icons.Default.Map, "Map") }
    }
}

@Composable
fun QuickActionButton(icon: ImageVector, text: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { /* TODO */ }) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(28.dp))
        }
        Text(text, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun ContentSection(title: String) {
    Column {
        Text(title, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(5) {
                ContentCard()
            }
        }
    }
}

@Composable
fun ContentCard() {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(220.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = "https://picsum.photos/seed/${System.currentTimeMillis()}/300/400",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text("Destination", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

@Composable
fun BottomAppBarComponent(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val items = BottomNavItems.list

    BottomAppBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
