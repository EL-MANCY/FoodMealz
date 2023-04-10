package com.example.domain.repo

import com.example.domain.entity.CategoryResponse

interface MealzRepo {
    suspend fun getMealsFromRemote() : CategoryResponse
}