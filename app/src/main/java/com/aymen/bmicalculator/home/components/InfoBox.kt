package com.aymen.bmicalculator.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aymen.bmicalculator.R
import com.aymen.bmicalculator.ui.theme.BlueTextColor

@Composable
fun InfoBox(
    text: String,
    number: Int,
    onPlus: () -> Unit,
    onMinus: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(border = BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp).fillMaxWidth()
        ) {

            IconButton(onClick = onMinus) {
                Icon(
                    painter = painterResource(id = R.drawable.minus_icon),
                    contentDescription = "Minus Icon"
                )
            }

            Text(
                text = number.toString(),
                color = BlueTextColor,
                style = MaterialTheme.typography.titleMedium
            )

            IconButton(onClick = onPlus) {
                Icon(
                    painter = painterResource(id = R.drawable.plus_icon),
                    contentDescription = "Plus Icon"
                )
            }

        }

    }

}

@Preview
@Composable
fun InfoBoxPreview() {
    InfoBox(text = "age", number = 22, onPlus = {}, onMinus = {})
}