package com.example.funnyfood.ui.detail.cookingstep

import android.widget.CheckBox
import android.widget.TextView
import com.example.funnyfood.core.Abstract
import com.example.funnyfood.core.Same

data class CookingStepUi(
    private val order: Int, private val step: String,
    private val duration: String,
    private val status: Boolean
) : Abstract.Object<Unit, Abstract.Mapper.Empty>, Same<CookingStepUi> {
    override fun map(mapper: Abstract.Mapper.Empty) {
        //todo fix empty mapper
    }

    fun show(stepIndex: TextView, stepName: TextView, checkbox: CheckBox, stepTime: TextView) {
stepIndex.text = order.toString()
        stepName.text = step
        stepTime.text = duration
    }

    override fun itemToCompare(item: CookingStepUi) = item.order == order
}