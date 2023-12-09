package com.aymen.bmicalculator.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.Gender -> genderChange(event.gender)
            is HomeEvent.Age -> ageChange(event.number)
            is HomeEvent.Weight -> weightChange(event.number)
            is HomeEvent.Height -> heightChange(event.number)
        }
    }

    private fun genderChange(gender: String) {
        state = state.copy(gender = gender)
    }

    private fun ageChange(number: Int) {
        state = state.copy(age = state.age + number)
    }

    private fun weightChange(number: Int) {
        state = state.copy(weight = state.weight + number)
    }

    private fun heightChange(number: Int) {
        state = state.copy(height = number)
    }

}