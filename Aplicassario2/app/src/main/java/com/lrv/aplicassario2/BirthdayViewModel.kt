package com.lrv.aplicassario2

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class BirthdayViewModel : ViewModel() {

    private val _birthdays = mutableStateListOf<Birthday>()
    val birthdays: List<Birthday> = _birthdays

    fun addBirthday(birthday: Birthday) {
        _birthdays.add(birthday)
    }

    fun getByGroup(group: String): List<Birthday> {
        return _birthdays.filter { it.group == group }
    }
}
