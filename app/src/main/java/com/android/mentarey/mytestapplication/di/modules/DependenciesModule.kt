package com.android.mentarey.mytestapplication.di.modules

import android.content.Context
import com.android.mentarey.mytestapplication.presentation.models.MyObjectBox
import com.android.mentarey.mytestapplication.presentation.models.Product
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
class DependenciesModule {
    @Singleton
    @Provides
    fun provideBoxStore(context: Context): BoxStore {
        return MyObjectBox.builder().androidContext(context).build()
    }

    @Singleton
    @Provides
    fun provideProductBox(boxStore: BoxStore): Box<Product> {
        return boxStore.boxFor(Product::class.java)
    }
}