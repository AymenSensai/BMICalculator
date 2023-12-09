package com.aymen.bmicalculator.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aymen.bmicalculator.ui.theme.Blue
import com.aymen.bmicalculator.ui.theme.BlueTextColor
import com.aymen.bmicalculator.ui.theme.LightGrey

@Composable
fun Height(height: Int, onHeightChange: (Int) -> Unit, modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(border = BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Height",
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "${height}cm",
            color = BlueTextColor,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = height.toFloat(),
            onValueChange = { newValue ->
                onHeightChange(newValue.toInt())
            },
            valueRange = 100f..200f,
            steps = 0,
            colors = SliderDefaults.colors(
                thumbColor = Blue,
                activeTickColor = Blue,
                activeTrackColor = Blue,
                inactiveTickColor = LightGrey,
                inactiveTrackColor = LightGrey
            )
        )

    }

}

@Preview
@Composable
fun HeightPreview() {
    Height(height = 175, onHeightChange = {})
}