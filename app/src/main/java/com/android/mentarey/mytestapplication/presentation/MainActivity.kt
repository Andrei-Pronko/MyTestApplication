package com.android.mentarey.mytestapplication.presentation

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.android.mentarey.mytestapplication.R
import com.android.mentarey.mytestapplication.di.TestApplication
import com.android.mentarey.mytestapplication.presentation.adapters.ProductListAdapter
import com.android.mentarey.mytestapplication.presentation.models.ProductUI
import com.android.mentarey.mytestapplication.presentation.mvp.MainPresenter
import com.android.mentarey.mytestapplication.presentation.mvp.MainView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

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
        mainPresenter.getAllProducts()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        val searchView = menu?.findItem(R.id.menu_action_search)?.actionView as SearchView
        mainPresenter.searchText(searchView)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_action_add -> {
                mainPresenter.addSomeProducts()
                true
            }
            R.id.menu_action_search -> {
                true
            }
            R.id.menu_action_sort -> {
                mainPresenter.sortProducts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.clearResources()
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

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
