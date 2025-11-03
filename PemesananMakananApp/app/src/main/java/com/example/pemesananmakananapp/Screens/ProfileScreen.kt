// Di dalam file: screens/ProfileScreen.kt

package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pemesananmakananapp.UserViewModel

@Composable
fun ProfileScreen(
    rootNavController: NavController,
    viewModel: UserViewModel //
) {
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text("Halaman Profile")

        }
    }
}