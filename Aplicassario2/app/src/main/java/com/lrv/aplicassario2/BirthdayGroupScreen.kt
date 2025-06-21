package com.lrv.aplicassario2

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayGroupScreen(viewModel: BirthdayViewModel, onBack: () -> Unit) {
    val groups = listOf("Família", "Amigos", "Trabalho")

    val birthdaysByGroup = groups.associateWith { group ->
        viewModel.getByGroup(group).collectAsState(initial = emptyList())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Por Grupo") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Voltar")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            groups.forEach { group ->
                item {
                    Text(
                        text = group,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                val birthdays by birthdaysByGroup.getValue(group)

                items(birthdays) { birthday ->
                    ListItem(
                        headlineContent = { Text(birthday.name) },
                        supportingContent = { Text(birthday.date) }
                    )
                }
            }
        }
    }
}
