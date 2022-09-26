package com.example.funnyfood.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.funnyfood.R
import com.example.funnyfood.core.FunnyFoodApp

class RecipesFragment : BaseFragment() {

    private lateinit var viewModel: RecipeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity().application as FunnyFoodApp).recipesViewModel
    }

    override fun getTitle() = getString(R.string.app_name)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecipesAdapter()

        recyclerView?.adapter = adapter

        viewModel.observe(this, Observer {
            adapter.setData(it)
        })

    }

}

