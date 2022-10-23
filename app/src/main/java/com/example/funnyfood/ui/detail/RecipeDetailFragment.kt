package com.example.funnyfood.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.funnyfood.R
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.databinding.FragmentDetailBinding
import com.example.funnyfood.ui.BaseFragment
import com.example.funnyfood.ui.detail.cookingstep.CookingStepAdapter
import com.example.funnyfood.ui.detail.ingredient.IngredientAdapter

class RecipeDetailFragment : BaseFragment() {

    private lateinit var viewModel: RecipeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = (requireActivity().application as FunnyFoodApp).recipeDetailViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(
            true
        )



        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun getTitle(): String {
        return "Рецепт" // todo fix getTitle DetailFragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchRecipe()

        val binding = FragmentDetailBinding.bind(view)
        val adapterIngredient = IngredientAdapter()
        val adapterCookingStep = CookingStepAdapter()


        viewModel.observe(this, Observer {
            it.forEach {
                it.show(binding, adapterIngredient, adapterCookingStep)

            }
        })
        viewModel.init()
    }
}