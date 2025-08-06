package com.example.fakestore.data.repository

import com.example.fakestore.data.remote.FakeStoreApi
import com.example.fakestore.domain.model.Product
import com.example.fakestore.domain.repository.ProductRepository
import com.example.fakestore.util.ResultWrapper

class ProductRepositoryImpl(private val api: FakeStoreApi) : ProductRepository {
    override suspend fun getProducts(): ResultWrapper<List<Product>> {
        return try {
            val products = api.getProducts().map {
                Product(it.id, it.title, it.price, it.description, it.images.firstOrNull() ?: "")
            }
            ResultWrapper.Success(products)
        } catch (e: Exception) {
            ResultWrapper.Error(e.message ?: "Unknown error")
        }
    }
}
