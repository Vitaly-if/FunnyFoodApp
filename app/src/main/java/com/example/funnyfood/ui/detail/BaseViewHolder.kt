package com.example.funnyfood.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<E>(view: View) :
    RecyclerView.ViewHolder(view) {
    open fun bind(item: E) {}
    }