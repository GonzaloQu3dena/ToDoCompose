package com.qu3dena.todocompose.shared.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.runtime.Composable
import androidx.compose.material3.FloatingActionButton

@Composable
fun GenericFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    containerColor: Color = Color.LightGray
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        containerColor = containerColor
    ) {
        icon()
    }
}

