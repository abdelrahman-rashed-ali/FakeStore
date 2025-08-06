package com.example.fakestore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fakestore.domain.model.Product
import com.example.fakestore.presentation.details.DetailScreen
import com.example.fakestore.presentation.home.HomeScreen

@Composable
fun AppNavigation(homeScreen: @Composable () -> Unit, detailScreen: @Composable (Int) -> Unit) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { homeScreen() }
        composable("detail/{productId}", arguments = listOf(navArgument("productId") { type = NavType.IntType })) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("productId") ?: 0
            detailScreen(id)
        }
    }
}
