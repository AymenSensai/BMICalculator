package com.aymen.bmicalculator.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aymen.bmicalculator.ui.BmiButton
import com.aymen.bmicalculator.R
import com.aymen.bmicalculator.home.components.Gender
import com.aymen.bmicalculator.home.components.Height
import com.aymen.bmicalculator.home.components.InfoBox
import com.aymen.bmicalculator.ui.theme.BlueTextColor

@Composable
fun HomeScreen(
    state: HomeState,
    onEvent: (HomeEvent) -> Unit,
    navigateToScoreScreen: () -> Unit
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {

        Text(
            text = "BMI Calculator",
            color = BlueTextColor,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Gender(
                icon = R.drawable.male_icon,
                genderText = "Male",
                genderSelected = state.gender,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                onClick = { onEvent(HomeEvent.Gender("Male")) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Gender(
                icon = R.drawable.female_icon,
                genderText = "Female",
                genderSelected = state.gender,
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                onClick = { onEvent(HomeEvent.Gender("Female")) }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Height(
            height = state.height,
            onHeightChange = { height -> onEvent(HomeEvent.Height(height)) }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            InfoBox(
                text = "Weight",
                number = state.weight,
                onPlus = { onEvent(HomeEvent.Weight(1)) },
                onMinus = { onEvent(HomeEvent.Weight(-1)) },
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            InfoBox(
                text = "Age",
                number = state.age,
                onPlus = { onEvent(HomeEvent.Age(1)) },
                onMinus = { onEvent(HomeEvent.Age(-1)) },
                modifier = Modifier
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        BmiButton(
            text = "CALCULATE BMI",
            modifier = Modifier.fillMaxWidth(),
            onClick = navigateToScoreScreen
        )

    }

}

@Preview(backgroundColor = 0xFFE9F0FA)
@Composable
fun HomeScreenPreview() {
    val state = HomeState(
        gender = "Male",
        height = 180,
        weight = 60,
        age = 22
    )
    HomeScreen(
        state = state,
        onEvent = {},
        navigateToScoreScreen = {}
    )
}