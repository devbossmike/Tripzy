package com.mike.tripzy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

@Composable
fun TripsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("My Trips", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        
        // TODO: Add a list or grid to display existing trips
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text("No trips planned yet.") // Placeholder when no trips exist
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        ExtendedFloatingActionButton(onClick = { /* TODO: Navigate to add new trip screen */ }) {
            Icon(Icons.Filled.Add, contentDescription = "Add New Trip")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add New Trip")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TripsScreenPreview() {
    TripsScreen()
}