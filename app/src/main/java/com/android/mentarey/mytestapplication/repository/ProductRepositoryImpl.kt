package com.android.mentarey.mytestapplication.repository

import com.android.mentarey.mytestapplication.presentation.models.Product
import com.android.mentarey.mytestapplication.presentation.models.Product_
import io.objectbox.Box
import io.reactivex.Completable
import io.reactivex.Single

class ProductRepositoryImpl(private val productBox: Box<Product>) : ProductRepository {
    override fun addProduct(product: Product): Completable {
        return Completable.fromRunnable { productBox.put(product) }
    }

    override fun getProductsByTitle(productTitle: String): Single<List<Product>> {
        return Single.fromCallable { productBox.query().equal(Product_.productTitle, productTitle).build().find() }
    }

    override fun getAllProducts(): Single<List<Product>> {
        return Single.fromCallable { productBox.all }
    }
}