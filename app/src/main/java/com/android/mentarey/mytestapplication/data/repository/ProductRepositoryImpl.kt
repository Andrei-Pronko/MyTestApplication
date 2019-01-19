package com.android.mentarey.mytestapplication.data.repository

import com.android.mentarey.mytestapplication.presentation.models.Product
import com.android.mentarey.mytestapplication.utils.ext.containsTextInProduct
import io.objectbox.Box
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class ProductRepositoryImpl(private val productBox: Box<Product>) : ProductRepository {

    override fun addProduct(product: Product): Completable {
        return Completable.fromRunnable { productBox.put(product) }
    }

    override fun addAllProducts(products: List<Product>): Completable {
        return Completable.fromRunnable { productBox.put(products) }
    }

    override fun getProductsByTitle(searchText: String): Observable<List<Product>> {
        return Observable.fromCallable {
            productBox.all.filter { product -> product.containsTextInProduct(searchText) }
        }
    }

    override fun getAllProducts(): Single<List<Product>> {
        return Single.fromCallable { productBox.all }
    }
}