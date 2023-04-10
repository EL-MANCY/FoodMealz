package com.example.foodmealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mealsViewModel:MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealsViewModel.getMeals()
        val mealsAdapter=MealsAdapter()
        val rv:RecyclerView = findViewById(R.id.category_rv)
        mealsViewModel.CategoryLiveData.observe(this,Observer{
            if(it!=null){
                mealsAdapter.submitList(it.categories)
                rv.adapter=mealsAdapter
            }

        } )

    }
}