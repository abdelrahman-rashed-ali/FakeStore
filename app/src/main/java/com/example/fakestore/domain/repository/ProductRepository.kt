package com.example.fakestore.domain.repository

import com.example.fakestore.domain.model.Product
import com.example.fakestore.util.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(): ResultWrapper<List<Product>>
}