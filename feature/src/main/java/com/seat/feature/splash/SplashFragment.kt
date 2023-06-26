package com.seat.feature.splash

import android.os.Bundle
import android.view.View
import com.seat.commons.binding.viewBinding
import com.seat.commons.ui.BaseFragment
import com.seat.commons.ui.utils.observe
import com.seat.feature.R
import com.seat.feature.databinding.SplashFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.animation) {
            if (it.not()) {
                viewModel.navToDashboard()
            }
        }
    }
}
