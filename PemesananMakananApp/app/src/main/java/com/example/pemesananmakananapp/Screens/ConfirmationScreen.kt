// Di dalam file: screens/ConfirmationScreen.kt

package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pemesananmakananapp.Screen
import com.example.pemesananmakananapp.UserViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun ConfirmationScreen(
    navController: NavController,
    viewModel: UserViewModel
) {

    val username by viewModel.username.collectAsState()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {

                Text(
                    "Halo ${username},",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Terimakasih sudah memesan dan mohon tunggu " +
                            "dirumah sampai kurir mengantarkan pesananan anda",
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Start
                )
            }
            Button(
                onClick = {
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Main.route) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Selesai")
            }
        }
    }
}