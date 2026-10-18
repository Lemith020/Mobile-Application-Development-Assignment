package com.example.simple_registrationform
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme(
                    colorScheme = lightColorScheme(
                            primary = Color(0xFF7560D4),
                            background = Color(0xFFF6F4FC),
                            surface = Color.White
                    )
            ) {
                var showSuccess by rememberSaveable {
                    mutableStateOf(false)
                }

                BackHandler(enabled = showSuccess) {
                    showSuccess = false
                }

                if (showSuccess) {
                    SuccessScreen(
                            onBack = { showSuccess = false }
                    )
                } else {
                    RegistrationScreen(
                            onSubmit = { showSuccess = true }
                    )
                }
            }
        }
    }
}