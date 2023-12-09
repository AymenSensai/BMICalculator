package com.aymen.bmicalculator.home

sealed class HomeEvent {

    data class Gender(val gender: String) : HomeEvent()

    data class Age(val number: Int) : HomeEvent()

    data class Weight(val number: Int) : HomeEvent()

    data class Height(val number: Int) : HomeEvent()

}