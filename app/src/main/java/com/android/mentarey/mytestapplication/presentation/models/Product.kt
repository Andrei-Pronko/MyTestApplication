package com.android.mentarey.mytestapplication.presentation.models

import com.android.mentarey.mytestapplication.utils.constants.Global.EMPTY_LINE

data class Product(
    val id: Long = 0,
    val productTitle: String = EMPTY_LINE,
    val productInfo: String = EMPTY_LINE,
    val numberOfProduct: Int = 0,
    val costForOne: Double = 0.0,
    val available: Long = 0
)