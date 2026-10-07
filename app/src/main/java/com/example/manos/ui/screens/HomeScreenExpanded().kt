package com.example.manos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.manos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenExpanded() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Mi App (Expanded)") }) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(48.dp) // Márgenes más generosos para pantallas grandes
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.6f), // Centrar y limitar el ancho del contenido principal
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Text(
                    text = "Bienvenido a la versión de Escritorio / Tablet Grande",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineLarge
                )
                Button(onClick = {}) {
                    Text("Presioname")
                }
            }
        }
    }
}