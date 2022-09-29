package com.example.funnyfood.ui.detail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.ui.BaseFragment

class RecipeDetailFragment: BaseFragment() {

    private lateinit var viewModel: RecipeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (requireActivity().application as FunnyFoodApp.resipeDetailViewModel)
    }

    override fun getTitle(): String {
        return "Detail" // todo fix getTitle DetailFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RecipeDetailAdapter()

        recyclerView?.adapter = adapter

        viewModel.observe(this, Observer{
            adapter.setData(it)
        })
    }
}