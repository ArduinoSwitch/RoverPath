package com.seat.feature.newcommand

import android.os.Bundle
import android.view.View
import com.seat.commons.binding.hide
import com.seat.commons.binding.onClick
import com.seat.commons.binding.viewBinding
import com.seat.commons.ui.BaseFragment
import com.seat.domain.rovercommand.CardinalPoint
import com.seat.feature.R
import com.seat.feature.databinding.NewCommandFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewCommandFragment: BaseFragment(R.layout.new_command_fragment) {

    override val viewModel: NewCommandViewModel by viewModel()
    private val binding by viewBinding(NewCommandFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bind()
    }

    private fun NewCommandFragmentBinding.bind() {
        topPoint.editText?.bindTwoWay(viewModel.topPoint)
        rightPoint.editText?.bindTwoWay(viewModel.rightPoint)
        roverXPosition.editText?.bindTwoWay(viewModel.roverPointX)
        roverYPosition.editText?.bindTwoWay(viewModel.roverPointY)
        movements.editText?.bindTwoWay(viewModel.roverMovement)
        sendCommand.bindEnabled(viewModel.isEnabled)
        progressView.bindIsVisible(viewModel.loading)
        header.backButton.hide()
        directionSelector.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.north_button -> viewModel.setDirection(CardinalPoint.N)
                    R.id.sud_button -> viewModel.setDirection(CardinalPoint.S)
                    R.id.east_button -> viewModel.setDirection(CardinalPoint.E)
                    else -> viewModel.setDirection(CardinalPoint.W)
                }
            } else viewModel.setDirection(CardinalPoint.NONE)
        }
        sendCommand.onClick { viewModel.sendCommand() }
    }
}
