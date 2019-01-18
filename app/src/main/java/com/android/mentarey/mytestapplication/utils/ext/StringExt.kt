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