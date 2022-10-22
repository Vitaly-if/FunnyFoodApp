package com.example.funnyfood.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

abstract class BaseFragment : Fragment() {

    protected var recyclerView: RecyclerView? = null

    protected abstract fun getTitle(): String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = getTitle()

    }
}