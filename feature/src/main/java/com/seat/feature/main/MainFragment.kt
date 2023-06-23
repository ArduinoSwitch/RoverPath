package com.seat.feature.main

import android.os.Bundle
import android.view.View
import com.seat.commons.binding.viewBinding
import com.seat.commons.ui.BaseFragment
import com.seat.feature.R
import com.seat.feature.databinding.MainFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment(R.layout.main_fragment) {
    override val viewModel: MainViewModel by viewModel()
    private val binding: MainFragmentBinding by viewBinding(MainFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
