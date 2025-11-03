package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pemesananmakananapp.Screen
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.DisposableEffect
import com.example.pemesananmakananapp.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    rootNavController: NavController,
    viewModel: UserViewModel
) {

    val selectedFood by viewModel.selectedFoodName.collectAsState()


    val username by viewModel.username.collectAsState()


    DisposableEffect(Unit) {

        onDispose {
            viewModel.clearSelectedFood()
        }
    }


    var pesananAtasNama by remember(username) { mutableStateOf(username) }
    var detailPesanan by remember(selectedFood) {
        mutableStateOf(selectedFood ?: "")
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // Padding dari bottom nav
                .padding(16.dp), // Padding konten
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Halo ${username},",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = pesananAtasNama,
                onValueChange = { pesananAtasNama = it },
                label = { Text("Pesanan siapa") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = detailPesanan,
                onValueChange = { detailPesanan = it },
                label = { Text("Detail Pesanan") },
                placeholder = { Text("Contoh: Baksound") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    rootNavController.navigate(Screen.Address.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Kirim")
            }
        }
    }
}