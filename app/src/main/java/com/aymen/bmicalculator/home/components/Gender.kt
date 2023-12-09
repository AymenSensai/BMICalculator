package com.aymen.bmicalculator.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import com.aymen.bmicalculator.ui.theme.Blue
import com.aymen.bmicalculator.ui.theme.DarkGrey
import com.aymen.bmicalculator.ui.theme.LightGrey

@Composable
fun Gender(
    icon: Int,
    genderText: String,
    genderSelected: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    val selected = genderText == genderSelected

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(
                border = BorderStroke(
                    width = if (selected) 3.dp else 1.dp,
                    color = if (selected) Blue else DarkGrey
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .background(if (selected) Blue.copy(alpha = 0.1f) else LightGrey)
            .clickable { onClick() }
            .padding(vertical = 16.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = genderText,
            tint = if (selected) Blue else DarkGrey
        )
        Text(
            text = genderText,
            color = if (selected) Blue else Color.Black,
            style = MaterialTheme.typography.titleMedium
        )
    }

}

@Preview
@Composable
fun GenderPreview() {
    Gender(
        icon = R.drawable.male_icon,
        genderText = "Male",
        genderSelected = "Male",
        onClick = {}
    )
}