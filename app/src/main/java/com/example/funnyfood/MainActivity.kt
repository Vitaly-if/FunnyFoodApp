package com.example.funnyfood

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.databinding.ActivityMainBinding
import com.example.funnyfood.ui.Navigator.Base.Screens.Companion.RECIPE_LIST_SCREEN
import com.example.funnyfood.ui.recipes.RecipesFragment
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        val viewModel = (application as FunnyFoodApp).mainViewModel
        viewModel.observe(this) {
            val fragment = when (it) {
                RECIPE_LIST_SCREEN -> RecipesFragment()
                else -> throw IllegalStateException("screen id undefined $it")
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        }

        viewModel.init()

    }

}
