package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pemesananmakananapp.Screen
import com.example.pemesananmakananapp.UserViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressScreen(
    navController: NavController,
    viewModel: UserViewModel
) {

    val username by viewModel.username.collectAsState()

    var namaLengkap by remember(username) { mutableStateOf(username) } // Otomatis isi nama
    var alamat by remember { mutableStateOf("") }
    var rincianAlamat by remember { mutableStateOf("") }

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
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    "Alamat Pengiriman",
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(32.dp))

                OutlinedTextField(
                    value = namaLengkap,
                    onValueChange = { namaLengkap = it },
                    label = { Text("Nama Lengkap") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = alamat,
                    onValueChange = { alamat = it },
                    label = { Text("Alamat") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = rincianAlamat,
                    onValueChange = { rincianAlamat = it },
                    label = { Text("Rincian alamat lengkap") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 3
                )
            }
            Button(
                onClick = {
                    navController.navigate(Screen.Confirmation.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Order dan Kirim")
            }
        }
    }
}