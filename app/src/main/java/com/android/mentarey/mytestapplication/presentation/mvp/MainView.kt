package com.android.mentarey.mytestapplication.presentation.mvp

import com.arellomobile.mvp.MvpView
import com.android.mentarey.mytestapplication.presentation.models.Product

interface MainView : MvpView {
    fun updateData(data: List<Product>)
}