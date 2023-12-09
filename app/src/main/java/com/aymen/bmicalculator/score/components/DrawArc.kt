package com.aymen.bmicalculator.score.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke

fun DrawScope.drawArc(startAngle: Float, strokeWidth: Float, color: Color) {
    val sweepAngle = if (startAngle != 0f) {
        270f - startAngle
    } else {
        270f
    }
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(width = strokeWidth)
    )
}

fun DrawScope.drawBlueArc(progress: Float, startAngle: Float, strokeWidth: Float, color: Color) {
    val sweepAngle = if (startAngle != 0f) {
        startAngle * progress
    } else {
        progress * 90
    }
    drawArc(
        color = color,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(width = strokeWidth)
    )
}