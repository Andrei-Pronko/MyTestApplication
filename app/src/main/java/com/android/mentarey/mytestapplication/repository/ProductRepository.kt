package com.android.mentarey.mytestapplication.repository

import com.android.mentarey.mytestapplication.presentation.models.Product
import io.reactivex.Completable
import io.reactivex.Single

interface ProductRepository {
    fun addProduct(product: Product): Completable
    fun getProductsByTitle(productTitle: String): Single<List<Product>>
    fun getAllProducts(): Single<List<Product>>
}