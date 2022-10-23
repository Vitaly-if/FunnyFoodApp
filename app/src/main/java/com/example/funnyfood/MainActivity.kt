package com.example.funnyfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.databinding.ActivityMainBinding
import com.example.funnyfood.ui.MainViewModel
import com.example.funnyfood.ui.Navigator.Base.Screens.Companion.RECIPE_DETAIL_SCREEN
import com.example.funnyfood.ui.Navigator.Base.Screens.Companion.RECIPE_LIST_SCREEN
import com.example.funnyfood.ui.detail.RecipeDetailFragment
import com.example.funnyfood.ui.recipes.RecipesFragment
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        val view = binding.root
        setContentView(view)
        setSupportActionBar(findViewById(R.id.toolbar))

        viewModel = (application as FunnyFoodApp).mainViewModel
        viewModel.observe(this) {
            val fragment = when (it) {
                RECIPE_LIST_SCREEN -> RecipesFragment()
                RECIPE_DETAIL_SCREEN -> RecipeDetailFragment()
                else -> throw IllegalStateException("screen id undefined $it")
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        }

        viewModel.init()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        if (item.itemId == R.id.menu) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onBackPressed() {
        if (viewModel.navigateBack())
            super.onBackPressed()
    }

}
