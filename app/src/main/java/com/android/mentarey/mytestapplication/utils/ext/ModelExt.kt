package com.android.mentarey.mytestapplication.utils.ext

import com.android.mentarey.mytestapplication.presentation.models.Product
import com.android.mentarey.mytestapplication.presentation.models.ProductUI

fun Product.toProductUI(): ProductUI {
    return ProductUI().apply {
        productTitle = this@toProductUI.productTitle
        productInfo = this@toProductUI.productInfo
        costForOne = this@toProductUI.costForOne.toString()
        numberOfProduct = this@toProductUI.numberOfProduct.toString()
        totalCost = this@toProductUI.totalCost.toString()
    }
}

fun List<Product>.toListProductsUI(): List<ProductUI> {
    return this.map { it.toProductUI() }
}

fun Product.containsTextInProduct(text: String): Boolean {
    val lowerTitle = this.toProductUI().toString().toLowerCase()
    val lowerText = text.toLowerCase()
    return lowerTitle.contains(lowerText)
}

fun List<ProductUI>.sortByName(): List<ProductUI> {
    return this.sortedWith(compareBy({ it.productTitle }, { it.productInfo }))
}