package com.mentarey.android.testapplication.data.repository

import com.android.mentarey.mytestapplication.repository.ProductRepository
import com.android.mentarey.mytestapplication.presentation.models.Product
import io.reactivex.Completable
import io.reactivex.Single

class ProductRepositoryImpl : ProductRepository {
    override fun addProduct(product: Product): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getProductsByTitle(): Single<List<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getAllProducts(): Single<List<Product>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}