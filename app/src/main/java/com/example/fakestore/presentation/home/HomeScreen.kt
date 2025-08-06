package com.example.fakestore.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.fakestore.presentation.components.ProductCard
import com.example.fakestore.util.ResultWrapper

@Composable
fun HomeScreen(viewModel: HomeViewModel, onProductClick: (Int) -> Unit) {
    val state by viewModel.state.collectAsState()

    when (state) {
        is ResultWrapper.Loading -> CircularProgressIndicator()
        is ResultWrapper.Error -> Snackbar { Text((state as ResultWrapper.Error).message) }
        is ResultWrapper.Success -> {
            val products = (state as ResultWrapper.Success).data
            LazyColumn {
                items(products) { product ->
                    ProductCard(product) { onProductClick(product.id) }
                }
            }
        }
    }
}
