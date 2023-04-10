package com.example.foodmealz.di

import com.example.data.remote.ApiService
import com.example.data.repo.MealsRepoImpl
import com.example.domain.repo.MealzRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object repoModule {

    @Provides
    fun provideRepo(apiService: ApiService): MealzRepo {
        return MealsRepoImpl(apiService)
    }
}