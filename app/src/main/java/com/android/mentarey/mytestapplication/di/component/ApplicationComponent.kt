package com.android.mentarey.mytestapplication.di.component

import com.android.mentarey.mytestapplication.presentation.MainActivity
import com.android.mentarey.mytestapplication.di.modules.AndroidModule
import com.android.mentarey.mytestapplication.di.modules.DependenciesModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [
        AndroidInjectionModule::class,
        AndroidModule::class,
        DependenciesModule::class
    ]
)
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}