package com.example.funnyfood

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.databinding.ActivityMainBinding
import com.example.funnyfood.ui.RecipeUi
import com.example.funnyfood.ui.RecipesAdapter
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import java.io.InputStreamReader

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
            RecipeUi.Base(1,"recipe", "time", "4"),
            RecipeUi.Base(2,"recipe2", "time", "4"),
            RecipeUi.Base(3,"recipe3", "time", "4"),
        )
        viewModel.observe(this, Observer {
            adapter.setData(it)
        })
        //adapter.setData(list)


    }

}
