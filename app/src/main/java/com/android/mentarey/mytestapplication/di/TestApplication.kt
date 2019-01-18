package com.android.mentarey.mytestapplication.di

import android.app.Application
import com.android.mentarey.mytestapplication.di.component.ApplicationComponent
import com.android.mentarey.mytestapplication.di.component.DaggerApplicationComponent
import com.android.mentarey.mytestapplication.di.modules.AndroidModule

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        applicationComponent =
                DaggerApplicationComponent.builder().androidModule(AndroidModule(this)).build()
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }
}