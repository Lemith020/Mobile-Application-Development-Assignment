package com.example.simple_registrationform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SuccessScreen(onBack: () -> Unit) {
    Box(
            modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .safeDrawingPadding()
                    .padding(24.dp),
            contentAlignment = Alignment.Center
    ) {
        Card(
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(
                        containerColor = Color.White
                )
        ) {
            Column(
                    modifier = Modifier
                            .fillMaxWidth()
                            .padding(28.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                        modifier = Modifier
                                .size(88.dp)
                                .background(
                                        color = Color(0xFFE9F7EF),
                                        shape = CircleShape
                                ),
                        contentAlignment = Alignment.Center
                ) {
                    Text(
                            text = "✓",
                            fontSize = 48.sp,
                            color = Color(0xFF35A56C)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                        text = "Registration\nSuccessful!",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF29243D)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                        text = "Your registration was successful!",
                        color = Color(0xFF827C93),
                        textAlign = TextAlign.Center,
                        fontSize = 15.sp
                )

                Spacer(modifier = Modifier.height(28.dp))

                Button(
                        onClick = onBack,
                        modifier = Modifier
                                .fillMaxWidth()
                                .height(54.dp),
                        shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                            text = "Back to form",
                            fontSize = 16.sp
                    )
                }
            }
        }
    }
}