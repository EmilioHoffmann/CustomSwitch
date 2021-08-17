package com.hoffmann.emilio.custom_switch

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import com.hoffmann.emilio.custom_switch.databinding.CustomSwitchBinding

class CustomSwitch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: CustomSwitchBinding = CustomSwitchBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    private var selectedOption = SwitchSelected.FIRST

    init {
        context.withStyledAttributes(attrs, R.styleable.CustomSwitch, 0, 0) {
            setTexts(
                getString(R.styleable.CustomSwitch_firstOption) ?: "",
                getString(R.styleable.CustomSwitch_secondOption) ?: ""
            )
        }
    }

    private fun setTexts(firstOption: String, secondOption: String) {
        binding.firstOptionText.text = firstOption
        binding.secondOptionText.text = secondOption
    }

    fun setSwitchChangedListener(listener: (SwitchSelected) -> Unit) {
        binding.firstOptionSection.setOnClickListener {
            if (selectedOption == SwitchSelected.SECOND) {
                listener.invoke(SwitchSelected.FIRST)
                selectedOption = SwitchSelected.FIRST
                binding.root.transitionToStart()
            }
        }
        binding.secondOptionSection.setOnClickListener {
            if (selectedOption == SwitchSelected.FIRST) {
                listener.invoke(SwitchSelected.SECOND)
                selectedOption = SwitchSelected.SECOND
                binding.root.transitionToEnd()
            }
        }
    }

    enum class SwitchSelected {
        FIRST,
        SECOND
    }
}
