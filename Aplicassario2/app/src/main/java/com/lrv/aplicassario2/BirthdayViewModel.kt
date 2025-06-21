package com.lrv.aplicassario2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class BirthdayViewModel(private val dao: BirthdayDao) : ViewModel() {

    val birthdays: StateFlow<List<Birthday>> = dao.getAll()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addBirthday(birthday: Birthday) {
        viewModelScope.launch {
            dao.insert(birthday)
        }
    }

    fun getByGroup(group: String): StateFlow<List<Birthday>> {
        return dao.getByGroup(group)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    }
}
