package com.android.mentarey.mytestapplication.presentation.mvp

import android.support.v7.widget.SearchView
import com.android.mentarey.mytestapplication.data.repository.ProductRepository
import com.android.mentarey.mytestapplication.utils.Global
import com.android.mentarey.mytestapplication.utils.RxSearchObservable
import com.android.mentarey.mytestapplication.utils.ext.sortByName
import com.android.mentarey.mytestapplication.utils.ext.toListProductsUI
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(private val productRepository: ProductRepository) : MvpPresenter<MainView>() {

    private val compositeDisposable = CompositeDisposable()

    fun getAllProducts() {
        compositeDisposable.add(productRepository.getAllProducts()
            .map { it.toListProductsUI() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { listProduct -> viewState.updateData(listProduct) },
                { error -> viewState.showMessage(error.localizedMessage) })
        )
    }

    fun addSomeProducts() {
        val productList = Global.createListOfProducts()
        compositeDisposable.add(
            productRepository.addAllProducts(productList)
                .andThen { getAllProducts() }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe()
        )
    }

    fun searchText(searchView: SearchView) {
        compositeDisposable.add(RxSearchObservable.fromView(searchView)
            .debounce(300, TimeUnit.MILLISECONDS)
            .switchMap { query -> productRepository.getProductsByTitle(query) }
            .map { it.toListProductsUI() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { listProduct -> viewState.updateData(listProduct) },
                { error -> viewState.showMessage(error.localizedMessage) })
        )
    }

    fun sortProducts() {
        compositeDisposable.add(productRepository.getAllProducts()
            .map { it.toListProductsUI().sortByName() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { listProduct -> viewState.updateData(listProduct.sortByName()) },
                { error -> viewState.showMessage(error.localizedMessage) })
        )
    }

    fun clearResources() {
        compositeDisposable.dispose()
    }
}