package com.seat.rover.splash

import android.os.Bundle
import android.view.View
import com.seat.commons.binding.viewBinding
import com.seat.commons.ui.BaseFragment
import com.seat.commons.ui.utils.observe
import com.seat.rover.R
import com.seat.rover.databinding.SplashFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()
    private val binding: SplashFragmentBinding by viewBinding(SplashFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.animation) {
            if (it.not()) {
                viewModel.navToDashboard()
            }
        }
    }
}
