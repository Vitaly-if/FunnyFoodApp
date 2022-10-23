package com.example.funnyfood.domain.detail.ingredient

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.detail.ingredient.IngredientUi

interface IngredientsDomainToUiMapper : Abstract.Mapper {
    fun map(list: List<IngredientDomain>): List<IngredientUi>
}