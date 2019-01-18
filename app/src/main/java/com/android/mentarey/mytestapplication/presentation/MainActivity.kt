package com.android.mentarey.mytestapplication.presentation

import android.os.Bundle
import com.android.mentarey.mytestapplication.R
import com.arellomobile.mvp.MvpAppCompatActivity
import com.android.mentarey.mytestapplication.di.TestApplication
import com.android.mentarey.mytestapplication.presentation.models.Product
import com.android.mentarey.mytestapplication.presentation.mvp.MainView

class MainActivity : MvpAppCompatActivity(), MainView {
    override fun updateData(data: List<Product>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TestApplication.applicationComponent.inject(this)
        setContentView(R.layout.activity_main)
    }
}
