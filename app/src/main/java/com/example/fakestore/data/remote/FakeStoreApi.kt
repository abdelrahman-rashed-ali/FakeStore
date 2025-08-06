package com.example.fakestore.data.remote

import com.example.fakestore.data.model.ProductDto
import retrofit2.http.GET

interface FakeStoreApi {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>
}