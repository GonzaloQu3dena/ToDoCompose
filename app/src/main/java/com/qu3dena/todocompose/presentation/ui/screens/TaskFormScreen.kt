package com.qu3dena.todocompose.presentation.ui.screens

import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.runtime.Composable

import androidx.compose.material3.Text
import androidx.compose.material3.Icon

import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Save
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import com.qu3dena.todocompose.shared.components.GenericFloatingActionButton
import com.qu3dena.todocompose.shared.components.GenericOutlinedTextField

@Composable
fun TaskFormScreen(
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var description by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                fontSize = 21.sp,
                text = "Task Form",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            GenericOutlinedTextField(
                value = title,
                label = "Enter title",
                onValueChange = { title = it }
            )

            Spacer(modifier = Modifier.padding(vertical = 5.dp))

            GenericOutlinedTextField(
                value = description,
                label = "Enter description",
                onValueChange = { description = it }
            )
        }

        GenericFloatingActionButton(
            modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp),
            icon = {
                Icon(
                    imageVector = Icons.Default.Save,
                    contentDescription = null,
                )
            },
            onClick = {
               /*TODO*/
            }
        )
    }
}
