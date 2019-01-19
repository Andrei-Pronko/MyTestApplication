package com.android.mentarey.mytestapplication.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.mentarey.mytestapplication.R
import com.android.mentarey.mytestapplication.presentation.models.ProductUI
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.product_card.*

class ProductListAdapter internal constructor(private val productUIList: List<ProductUI>) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bind(productUI: ProductUI) {
            text_product_title.text = productUI.productTitle
            text_product_info.text = productUI.productInfo
            text_cost_for_one.text = productUI.costForOne
            text_numbers_of_products.text = productUI.numberOfProduct
            text_total_cost.text = productUI.totalCost
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_card, parent, false)
        return ProductViewHolder(productView)
    }

    override fun getItemCount(): Int = productUIList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(productUI = productUIList[position])
}