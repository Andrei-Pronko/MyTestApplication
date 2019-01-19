package com.android.mentarey.mytestapplication.data.repository

import com.android.mentarey.mytestapplication.presentation.models.Product
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ProductRepository {
    fun addProduct(product: Product): Completable
    fun addAllProducts(products: List<Product>): Completable
    fun getProductsByTitle(searchText: String): Observable<List<Product>>
    fun getAllProducts(): Single<List<Product>>
}