package com.seat.feature.onboarding

import android.os.Bundle
import android.view.View
import com.seat.commons.binding.hide
import com.seat.commons.binding.onClick
import com.seat.commons.binding.viewBinding
import com.seat.commons.ui.BaseFragment
import com.seat.feature.R
import com.seat.feature.databinding.OnBoardingFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingFragment : BaseFragment(R.layout.on_boarding_fragment) {
    private val binding: OnBoardingFragmentBinding by viewBinding(OnBoardingFragmentBinding::bind)
    override val viewModel: OnBoardingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bind()
    }

    private fun OnBoardingFragmentBinding.bind() {
        header.backButton.hide()
        header.closeButton.onClick {
            viewModel.navToMain()
        }
        incomingButton.onClick {
            viewModel.navToMain()
        }
    }
}
