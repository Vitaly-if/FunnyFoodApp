package com.example.funnyfood

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.funnyfood.core.FunnyFoodApp
import com.example.funnyfood.ui.MainViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      val viewModel = (application as FunnyFoodApp).mainViewModel
      viewModel.fetchBooks()
    }
}