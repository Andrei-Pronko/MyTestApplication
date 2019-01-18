package com.android.mentarey.mytestapplication.di.modules

import com.android.mentarey.mytestapplication.repository.ProductRepository
import com.android.mentarey.mytestapplication.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository
}