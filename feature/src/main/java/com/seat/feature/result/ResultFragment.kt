package com.seat.feature.result

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.seat.commons.binding.onClick
import com.seat.commons.binding.viewBinding
import com.seat.commons.ui.BaseFragment
import com.seat.feature.R
import com.seat.feature.databinding.ResultFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ResultFragment: BaseFragment(R.layout.result_fragment) {

    private val args: ResultFragmentArgs by navArgs()
    override val viewModel: ResultViewModel by viewModel()
    private val binding by viewBinding(ResultFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bind()
    }

    private fun ResultFragmentBinding.bind() {
        header.backButton.onClick { viewModel.navigateBack() }
        actualPositionValue.text = getString(
            R.string.position_placeholder,
            args.state.position.x,
            args.state.position.y
        )
        actualDirectionValue.text = args.state.direction
    }
}