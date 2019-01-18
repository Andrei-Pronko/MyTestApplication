package com.android.mentarey.mytestapplication.presentation

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.mentarey.mytestapplication.R
import com.arellomobile.mvp.MvpAppCompatActivity
import com.android.mentarey.mytestapplication.di.TestApplication
import com.android.mentarey.mytestapplication.presentation.adapters.ProductListAdapter
import com.android.mentarey.mytestapplication.presentation.models.Product
import com.android.mentarey.mytestapplication.presentation.models.ProductUI
import com.android.mentarey.mytestapplication.presentation.mvp.MainPresenter
import com.android.mentarey.mytestapplication.presentation.mvp.MainView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import com.arellomobile.mvp.presenter.ProvidePresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    @ProvidePresenter
    fun provideMainPresenter(): MainPresenter {
        return mainPresenter
    }

    private var productList: ArrayList<ProductUI> = ArrayList()
    private var productListAdapter: ProductListAdapter = ProductListAdapter(productList)

    override fun onCreate(savedInstanceState: Bundle?) {
        TestApplication.applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        prepareRecyclerView()
    }

    private fun prepareRecyclerView() {
        product_recycler_view.setHasFixedSize(true)
        product_recycler_view.layoutManager = LinearLayoutManager(this)
        product_recycler_view.adapter = productListAdapter
    }

    override fun updateData(data: List<ProductUI>) {
        productList.clear()
        productList.addAll(data)
        productListAdapter.notifyDataSetChanged()
    }
}
