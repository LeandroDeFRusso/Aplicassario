package com.lrv.aplicassario2
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthdayGroupScreen(viewModel: BirthdayViewModel, onBack: () -> Unit) {
    val groups = listOf("Família", "Amigos", "Trabalho")

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
                items(viewModel.getByGroup(group)) { birthday ->
                    ListItem(
                        headlineContent = { Text(birthday.name) },
                        supportingContent = { Text(birthday.date) }
                    )

                }
            }
        }
    }
}
