package com.example.foodmealz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.CategoryResponse
import com.example.domain.usecase.GetMealz
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MealsViewModel @Inject constructor(private val getMealsUseCase:GetMealz):ViewModel() {

    private val TAG = "MealsViewModel"

    private var CategoryMutableLiveData = MutableLiveData<CategoryResponse?>()
    val CategoryLiveData: LiveData<CategoryResponse?>
        get() = CategoryMutableLiveData

    fun getMeals(){
        viewModelScope.launch {
            try {
                CategoryMutableLiveData.postValue(getMealsUseCase())
            }catch (e:Exception){
                Log.i(TAG,e.message.toString())
            }
        }
    }
}