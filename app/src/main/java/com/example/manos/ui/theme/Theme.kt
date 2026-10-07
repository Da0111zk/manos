package com.example.manos.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Colores utilizados cuando la aplicación está en modo oscuro.
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

// Colores utilizados cuando la aplicación está en modo claro.
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* También se pueden agregar otros colores personalizados:
    background = ...
    surface = ...
    */
)

// Tema principal de la aplicación.
@Composable
fun ManosTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),

    // Permite utilizar los colores dinámicos de Android
    // en dispositivos compatibles.
    dynamicColor: Boolean = true,

    content: @Composable () -> Unit
) {

    // Selecciona el esquema de colores dependiendo
    // del modo claro u oscuro del dispositivo.
    val colorScheme = when {

        // Android 12 o superior puede utilizar colores dinámicos.
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current

            if (darkTheme) {
                dynamicDarkColorScheme(context)
            } else {
                dynamicLightColorScheme(context)
            }
        }

        // Si no se utilizan colores dinámicos,
        // se seleccionan los colores definidos anteriormente.
        darkTheme -> DarkColorScheme

        else -> LightColorScheme
    }

    // Aplica Material 3 a toda la aplicación.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}