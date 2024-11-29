package org.sopt.cgv.feature.seats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.sopt.cgv.core.data.repository.CgvRepository

class SeatSelectViewModelFactory(
    private val repository: CgvRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SeatSelectViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SeatSelectViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
