package com.example.funnyfood

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.databinding.ActivityMainBinding
import com.example.funnyfood.ui.MainViewModel
import com.example.funnyfood.ui.RecipeUiModel
import com.example.funnyfood.ui.RecipesAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
      val viewModel = (application as FunnyFoodApp).mainViewModel
      viewModel.fetchBooks()
        var adapter = RecipesAdapter()
        binding.recipeRecyclerView.adapter = adapter
        val list = listOf(
            RecipeUiModel.Base("recipe", "time", 4),
            RecipeUiModel.Base("recipe2", "time", 4),
            RecipeUiModel.Base("recipe3", "time", 4),
        )
        adapter.setData(list)
    }


}