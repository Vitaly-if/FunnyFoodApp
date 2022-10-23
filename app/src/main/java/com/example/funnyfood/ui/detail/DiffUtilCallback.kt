package com.example.funnyfood.ui.detail

import androidx.recyclerview.widget.DiffUtil
import com.example.funnyfood.core.Same

abstract class DiffUtilCallback<T : Same<T>>(
    private val oldList: List<T>,
    private val newList: List<T>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].itemToCompare(newList[newItemPosition])
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        newList[newItemPosition]?.equals(oldList[oldItemPosition])
}
