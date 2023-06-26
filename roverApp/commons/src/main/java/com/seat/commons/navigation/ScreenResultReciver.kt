package com.seat.commons.navigation

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.seat.commons.utils.LogConstants
import timber.log.Timber

interface ScreenResultReceiver {
    val screenResultKeys: List<String>
    fun onResult(key: String, result: ScreenResult)
}

interface ScreenResult : Parcelable

fun Fragment.delegateDialogResults(receiver: ScreenResultReceiver) {
    findNavController().currentBackStackEntry?.savedStateHandle?.let { savedStateHandle ->
        receiver.screenResultKeys.forEach { resultKey ->
            savedStateHandle.getLiveData<ScreenResult>(resultKey).observe(viewLifecycleOwner) {
                if (it != null) {
                    savedStateHandle.set(resultKey, null)
                    receiver.onResult(resultKey, it)
                }
            }
        }
    }
}

interface NavHostHolder {
    val navHostId: Int
}
