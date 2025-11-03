package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pemesananmakananapp.Screen
import androidx.compose.ui.res.painterResource
import com.example.pemesananmakananapp.R

@Composable
fun SplashScreen(navController: NavController) {


    Scaffold { innerPadding ->


        Column(
            modifier = Modifier
                .fillMaxSize()

                .padding(innerPadding)

                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.logo_app),
                        contentDescription = "Logo Aplikasi",
                        modifier = Modifier.size(150.dp) // Atur ukurannya
                    )

                    Spacer(modifier = Modifier.height(16.dp)) // Jarak

                    Text(
                        "Mesen Makanan",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }


                Button(
                    onClick = {
                        navController.navigate(Screen.Auth.route) {
                            popUpTo(Screen.Splash.route) { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Start now")
                }
            }
        }
    }
}