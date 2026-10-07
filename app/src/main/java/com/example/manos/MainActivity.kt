package com.example.manos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.manos.navigation.NavigationEvent
import com.example.manos.navigation.Screen
import com.example.manos.ui.screens.HomeScreen
import com.example.manos.ui.screens.ProfileScreen
import com.example.manos.ui.screens.SettingsScreen
import com.example.manos.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // ViewModel y NavController
            val viewModel: MainViewModel = viewModel()
            val navController = rememberNavController()

            // Escuchar eventos de navegación emitidos por el ViewModel
            LaunchedEffect(key1 = Unit) {
                viewModel.navigationEvents.collectLatest { event ->
                    when (event) {
                        is NavigationEvent.NavigateTo -> {
                            navController.navigate(route = event.route.route) {
                                event.popUpToRoute?.let { screen ->
                                    popUpTo(route = screen.route) { // <-- Se usa screen.route en lugar de solo 'it'
                                        inclusive = event.inclusive
                                    }
                                }
                                launchSingleTop = event.singleTop
                                restoreState = true
                            }
                        }
                        is NavigationEvent.PopBackStack -> navController.popBackStack()
                        is NavigationEvent.NavigateUp -> navController.navigateUp()
                    }
                }
            }

            // Layout base con NavHost
            Scaffold(
                modifier = Modifier.fillMaxSize()
            ) { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = Modifier.padding(paddingValues = innerPadding)
                ) {
                    composable(route = Screen.Home.route) {
                        HomeScreen(navController = navController, viewModel = viewModel)
                    }
                    composable(route = Screen.Profile.route) {
                        ProfileScreen(navController = navController, viewModel = viewModel)
                    }
                    composable(route = Screen.Settings.route) {
                        SettingsScreen(navController = navController, viewModel = viewModel)
                    }
                }
            }
        }
    }
}