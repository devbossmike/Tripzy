package com.mike.tripzy.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import androidx.compose.foundation.Image // Import Image composable
import androidx.compose.ui.res.painterResource // Import painterResource
import com.mike.tripzy.R // Import your R class to access drawables
import androidx.compose.ui.graphics.Brush // Import Brush for gradients
import com.mike.tripzy.ui.theme.DeepBlue // Import custom colors
import com.mike.tripzy.ui.theme.Purple // Import custom colors

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 2000
        ),
        label = "alpha animation"
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(3000) // Show splash screen for 3 seconds
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        DeepBlue,
                        Purple
                    )
                )
            )
            .alpha(alphaAnim.value),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_app_logo), // Replace with your logo drawable resource name
            contentDescription = "App Logo"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(onTimeout = {})
}