package com.example.funnyfood.domain.recipes

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.ResourceProvider
import com.example.funnyfood.ui.recipes.RecipesUi

abstract class RecipesDomainToUiMapper(resourceProvider: ResourceProvider):
    Abstract.Mapper.DomainToUi.Base<List<RecipeDomain>, RecipesUi>(resourceProvider)