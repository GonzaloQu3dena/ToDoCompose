package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Scaffold

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert

import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MainScreen(
    bodyContent: @Composable (Modifier) -> Unit,
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            AppBar(modifier = Modifier.fillMaxWidth())

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                bodyContent(Modifier.fillMaxSize())
            }

            NavBar(modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun AppBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .background(color = Color.LightGray),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    text = "ToDoCompose by Gonzalo Qu3dena"
                )
                Icon(
                    Icons.Default.MoreVert, contentDescription = null,
                )
            }
        }
    }
}

@Composable
private fun NavBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .height(80.dp)
            .fillMaxWidth()
            .background(color = Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {}
    }
}