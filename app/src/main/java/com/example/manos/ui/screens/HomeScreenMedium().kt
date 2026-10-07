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
fun HomeScreenMedium() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Mi App (Medium)") }) }
    ) { innerPadding ->
        // En pantallas Medium podemos usar una fila (Row) para aprovechar el ancho horizontal
        Row(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Bienvenido",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.headlineMedium // Tipografía más grande
                )
                Button(onClick = {}) {
                    Text("Presioname")
                }
            }

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "LogoApp",
                modifier = Modifier
                    .weight(1f)
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}