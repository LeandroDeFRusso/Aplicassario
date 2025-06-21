package com.lrv.aplicassario2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BirthdayViewModelFactory(
    private val dao: BirthdayDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BirthdayViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BirthdayViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
