package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import com.qu3dena.todocompose.shared.components.GenericFloatingActionButton

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigationToForm: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(text = "Home Screen")
        GenericFloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
            onClick = onNavigationToForm,
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        )
    }
}