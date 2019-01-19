package com.android.mentarey.mytestapplication.presentation.mvp

import com.android.mentarey.mytestapplication.presentation.models.ProductUI
import com.arellomobile.mvp.MvpView

interface MainView : MvpView {
    fun updateData(data: List<ProductUI>)
    fun showMessage(message: String)
}