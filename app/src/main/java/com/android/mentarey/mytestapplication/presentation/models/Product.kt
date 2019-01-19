package com.android.mentarey.mytestapplication.presentation.models

import com.android.mentarey.mytestapplication.utils.Global.EMPTY_LINE
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Product(
    @Id
    var id: Long = 0,
    var productTitle: String = EMPTY_LINE,
    var productInfo: String = EMPTY_LINE,
    var numberOfProduct: Int = 0,
    var costForOne: Double = 0.0,
    var totalCost: Double = 0.0
)