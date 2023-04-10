package com.example.foodmealz.di

import com.example.domain.repo.MealzRepo
import com.example.domain.usecase.GetMealz
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun providesUseCase(mealzRepo: MealzRepo):GetMealz {
        return GetMealz(mealzRepo)
    }

}