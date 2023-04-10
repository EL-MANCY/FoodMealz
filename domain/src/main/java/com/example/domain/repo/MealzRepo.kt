package com.example.domain.repo

import com.example.domain.entity.CategoryResponse

interface MealzRepo {
    fun getMealsFromRemote() : CategoryResponse
}