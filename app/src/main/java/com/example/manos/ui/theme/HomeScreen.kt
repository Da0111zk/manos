package com.example.manos.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.manos.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    // Scaffold organiza la estructura principal de la pantalla.
    Scaffold(

        // Barra superior de la aplicación.
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mi App Kotlin"
                    )
                }
            )
        }

    ) { innerPadding ->

        // Column organiza todos los elementos verticalmente.
        Column(
            modifier = Modifier
                // Respeta el espacio utilizado por el Scaffold.
                .padding(innerPadding)

                // Ocupa todo el espacio disponible.
                .fillMaxSize()

                // Agrega un margen interno de 16dp.
                .padding(16.dp),

            // Mantiene una separación uniforme entre los elementos.
            verticalArrangement = Arrangement.spacedBy(20.dp),

            // Centra los elementos horizontalmente.
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Texto principal de bienvenida.
            Text(
                text = "¡Bienvenido!",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Botón principal de la aplicación.
            Button(
                onClick = {
                    // Acción que se ejecutará al presionar el botón.
                }
            ) {
                Text(
                    text = "Presióname"
                )
            }

            // Imagen o logo de la aplicación.
            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),
                contentDescription = "Logo de la aplicación",

                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),

                contentScale = ContentScale.Fit
            )

            // Tarjeta agregada como nuevo elemento visual.
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier
                        .padding(16.dp),

                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    // Título de la tarjeta.
                    Text(
                        text = "Información",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )

                    // Descripción de la tarjeta.
                    Text(
                        text = "Esta tarjeta utiliza componentes de Material 3."
                    )
                }
            }

            // Variable que almacena el estado del Switch.
            var activado by remember {
                mutableStateOf(false)
            }

            // Switch para comprobar la interacción del usuario.
            Switch(
                checked = activado,

                onCheckedChange = {
                    activado = it
                }
            )

            // Texto que cambia dependiendo del estado del Switch.
            Text(
                text = if (activado) {
                    "Función activada"
                } else {
                    "Función desactivada"
                },
                color = MaterialTheme.colorScheme.onBackground
            )

            // Barra de progreso como elemento visual adicional.
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

// Vista previa de la pantalla principal.
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}