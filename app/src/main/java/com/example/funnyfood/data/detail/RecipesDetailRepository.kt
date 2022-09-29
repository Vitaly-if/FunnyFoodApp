package com.example.funnyfood.data.detail

interface RecipesDetailRepository {

    suspend fun fetchRecipesDetail(): RecipesDetailData

    class Base(
        private val cloudDataSource: RecipeDetailCloudDataSource,
        private val cacheDataSource: RecipeDetailCacheDataSource,
        private val recipesCloudMapper: RecipeDetailCloudMapper,
        private val recipesCacheDataSource: RecipeDetailCacheMapper
    ) : RecipesDetailRepository {
        override suspend fun fetchRecipesDetail() = try {
            val recipesCachList = cacheDataSource.fetchRecipes()
            if (recipesCachList.isEmpty()) {
                val recipesDetailCloudList = cloudDataSource.fetchRecipes()
                val recipe = recipesCloudMapper.map(recipesDetailCloudList)
                cacheDataSource.saveRecipe(recipe)
                RecipesDetailData.Success(recipe)
            } else {
                RecipesDetailData.Success(recipesCacheDataSource.map(recipesCachList))
            }
        } catch (e: Exception) {
            RecipesDetailData.Fail(e)
        }
    }
}