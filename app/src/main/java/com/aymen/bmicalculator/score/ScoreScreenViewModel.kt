package com.aymen.bmicalculator.score

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class ScoreScreenViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(ScoreState())
        private set

    init {
        calculateBMI(savedStateHandle)
    }

    private fun calculateBMI(savedStateHandle: SavedStateHandle) {
        val weight = savedStateHandle.get<Int>("weight") ?: 80
        val height = (savedStateHandle.get<Int>("height")?.toDouble())?.div(100) ?: 170.0
        val bmi = weight / (height * height)
        updateStateBasedOnBMI(bmi)
    }

    private fun updateStateBasedOnBMI(bmi: Double) {
        val message: String
        val description: String
        when {
            bmi < 18.5 -> {
                message = "Underweight"
                description =
                    "A BMI below 18.5 indicating that you might be undernourished or lacking sufficient body weight in relation to your height. Health risks associated with being underweight can include weakened immune function, nutritional deficiencies, and osteoporosis."
            }

            bmi in 18.5..24.9 -> {
                message = "Normal"
                description =
                    "A BMI of 18.5-24.9 suggests a healthy weight in relation to your height. It's associated with a lower risk of health problems. Maintaining a normal BMI is often linked with better overall health and reduced risk of various chronic conditions."
            }

            bmi in 25.0..29.9 -> {
                message = "Overweight"
                description =
                    "A BMI of 25.0-29.9 indicating an excess of body weight compared to what is considered optimal for health. It can be associated with health risks such as high blood pressure, type 2 diabetes, heart disease, and certain cancers."
            }

            bmi >= 30.0 -> {
                message = "Obsess"
                description =
                    "A BMI above 30.0 represents a significantly higher level of body weight in relation to height, signifying an increased risk for several health issues. These can include severe conditions such as cardiovascular diseases, stroke, type 2 diabetes, certain cancers, and other chronic health problems. There are various degrees of obesity (Class I, II, III), each with different health implications."
            }

            else -> error("Invalid params")
        }
        state = state.copy(score = bmi, message = message, description = description)
    }

}