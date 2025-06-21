package com.lrv.aplicassario2

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayListScreen(
    viewModel: BirthdayViewModel,
    onAddClick: () -> Unit,
    onGroupClick: () -> Unit
) {
    val birthdays by viewModel.birthdays.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Aniversários") },
                actions = {
                    IconButton(onClick = onGroupClick) {
                        Icon(Icons.Default.List, contentDescription = "Ver por grupo")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar")
            }
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(birthdays) { birthday ->
                ListItem(
                    headlineContent = { Text(birthday.name) },
                    supportingContent = { Text(birthday.date) }
                )
                Divider()
            }
        }
    }
}
