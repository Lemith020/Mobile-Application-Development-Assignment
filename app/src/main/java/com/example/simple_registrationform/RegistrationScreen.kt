package com.example.simple_registrationform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen(onSubmit: () -> Unit) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }

    val isFormFilled = fullName.isNotBlank() &&
            email.isNotBlank() &&
            age.isNotBlank() &&
            phone.isNotBlank() &&
            address.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .safeDrawingPadding()
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "LET’S GET STARTED",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Create your account",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF29243D)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Fill in your details to register.",
            color = Color(0xFF827C93),
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                FormField(
                    value = fullName,
                    onValueChange = { fullName = it },
                    label = "Full name"
                )

                FormField(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email",
                    keyboardType = KeyboardType.Email
                )

                FormField(
                    value = age,
                    onValueChange = { input ->
                        age = input.filter { it.isDigit() }
                    },
                    label = "Age",
                    keyboardType = KeyboardType.Number
                )

                FormField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = "Phone number",
                    keyboardType = KeyboardType.Phone
                )

                FormField(
                    value = address,
                    onValueChange = { address = it },
                    label = "Address",
                    singleLine = false
                )

                Spacer(modifier = Modifier.height(4.dp))

                Button(
                    onClick = onSubmit,
                    enabled = isFormFilled,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "Submit",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FormField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = singleLine,
        maxLines = if (singleLine) 1 else 3,
        shape = RoundedCornerShape(14.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}