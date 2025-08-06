package com.example.fakestore

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fakestore.presentation.details.DetailScreen
import com.example.fakestore.presentation.home.HomeScreen
import com.example.fakestore.presentation.home.HomeViewModel
import com.example.fakestore.ui.theme.FakeStoreTheme
import androidx.compose.runtime.collectAsState
import com.example.fakestore.data.remote.RetrofitInstance
import com.example.fakestore.data.repository.ProductRepositoryImpl
import com.example.fakestore.domain.repository.ProductRepository
import com.example.fakestore.domain.usecase.GetProductsUseCase

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FakeStoreTheme {
                val navController = rememberNavController()
                val repository = ProductRepositoryImpl(RetrofitInstance.api)
                val useCase = GetProductsUseCase(repository)
                val homeViewModel: HomeViewModel = HomeViewModel(useCase)
                val state = homeViewModel.state.collectAsState()

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        composable("home") {
                            HomeScreen(
                                viewModel = homeViewModel,
                                onProductClick = { productId ->
                                    navController.navigate("detail/$productId")
                                }
                            )
                        }

                        composable(
                            route = "detail/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
                            val product = if (state.value is com.example.fakestore.util.ResultWrapper.Success) {
                                (state.value as com.example.fakestore.util.ResultWrapper.Success).data
                                    .find { it.id == productId }
                            } else null

                            product?.let {
                                DetailScreen(product = it)
                            }
                        }
                    }
                }
            }
        }
    }
}
