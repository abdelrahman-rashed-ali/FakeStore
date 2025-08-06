package com.example.fakestore.domain.usecase

import com.example.fakestore.domain.repository.ProductRepository

class GetProductsUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke() = repository.getProducts()
}