package com.example.fakestore.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.domain.model.Product
import com.example.fakestore.domain.usecase.GetProductsUseCase
import com.example.fakestore.util.ResultWrapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getProductsUseCase: GetProductsUseCase) : ViewModel() {

    private val _state = MutableStateFlow<ResultWrapper<List<Product>>>(ResultWrapper.Loading)
    val state: StateFlow<ResultWrapper<List<Product>>> = _state

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _state.value = ResultWrapper.Loading
            _state.value = getProductsUseCase()
        }
    }
}
