package com.seat.commons.binding.binders

import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.seat.commons.binding.enableIf
import com.seat.commons.binding.showIf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface ViewBinders: BaseBinder {
    fun View.bindIsVisible(isVisible: Flow<Boolean>) {
        observe(isVisible) {
            showIf(it)
        }
    }

    fun Button.bindEnabled(isEnabled: Flow<Boolean>) {
        observe(isEnabled) {
            enableIf(it)
        }
    }
}

