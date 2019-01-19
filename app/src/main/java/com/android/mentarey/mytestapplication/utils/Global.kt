package com.android.mentarey.mytestapplication.utils

import com.android.mentarey.mytestapplication.presentation.models.Product

object Global {
    const val EMPTY_LINE = ""

    fun createListOfProducts(): List<Product> {
        val productList = ArrayList<Product>()

        val product1 = Product().apply {
            productTitle = "Хлеб"
            productInfo = "Черный"
            numberOfProduct = 2
            costForOne = 1.1
            totalCost = 2.2
        }

        val product2 = Product().apply {
            productTitle = "Чипсы"
            productInfo = "Lays"
            numberOfProduct = 5
            costForOne = 1.0
            totalCost = 5.0
        }

        val product3 = Product().apply {
            productTitle = "Вафельки"
            productInfo = "Артек"
            numberOfProduct = 2
            costForOne = 1.1
            totalCost = 2.2
        }

        val product4 = Product().apply {
            productTitle = "Вафельки"
            productInfo = "Апельсиновые"
            numberOfProduct = 2
            costForOne = 1.1
            totalCost = 2.2
        }
        return productList.apply {
            add(product1)
            add(product2)
            add(product3)
            add(product4)
        }
    }
}