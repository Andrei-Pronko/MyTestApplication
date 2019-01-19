package com.android.mentarey.mytestapplication.presentation.models

import com.android.mentarey.mytestapplication.utils.Global.EMPTY_LINE

data class ProductUI(
    var productTitle: String = EMPTY_LINE,
    var productInfo: String = EMPTY_LINE,
    var numberOfProduct: String = EMPTY_LINE,
    var costForOne: String = EMPTY_LINE,
    var totalCost: String = EMPTY_LINE
)