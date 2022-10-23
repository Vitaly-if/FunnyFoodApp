package com.example.funnyfood.ui.detail

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil

abstract class BaseAdapter<E, T : BaseViewHolder<E>> :
    RecyclerView.Adapter<T>(), ListMapper<E> {

    protected val list = ArrayList<E>()

    override fun getItemCount() = list.size

    override fun map(data: List<E>) {
        val diffCallback = diffUtilCallback(list, data)
        val result = DiffUtil.calculateDiff(diffCallback)
        list.clear()
        list.addAll(data)
        result.dispatchUpdatesTo(this)
    }

    abstract fun diffUtilCallback(list: List<E>, data: List<E>): DiffUtil.Callback

    override fun onBindViewHolder(holder: T, position: Int) =
        holder.bind(list[position])

    protected fun Int.makeView(parent: ViewGroup) =
        LayoutInflater.from(parent.context).inflate(this, parent, false)
}
