package com.example.funnyfood.domain

import com.example.funnyfood.core.Abstract
import com.example.funnyfood.ui.RecipeUi

sealed class RecipeDomain : Abstract.Object<RecipeUi, RecipeDomainToUiMapper>
