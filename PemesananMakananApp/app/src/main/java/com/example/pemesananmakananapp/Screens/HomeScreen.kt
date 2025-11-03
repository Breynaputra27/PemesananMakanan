package com.example.pemesananmakananapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pemesananmakananapp.R
import com.example.pemesananmakananapp.UserViewModel


data class FoodItem(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int
)


val dummyFoodList = listOf(
    FoodItem(1, "Nasi Goreng", "Nasi goreng dengan telur...", R.drawable.nasi_goreng),
    FoodItem(2, "Sate Ayam", "10 Tusuk sate ayam...", R.drawable.sate_ayam),
    FoodItem(3, "Rendang", "Daging sapi empuk...", R.drawable.rendang),
    FoodItem(4, "Soto Ayam", "Soto ayam dengan koya...", R.drawable.soto_ayam),
    FoodItem(5, "Gado-Gado", "Sayuran segar bumbu...", R.drawable.gado_gado),
    FoodItem(6, "Ayam Bakar", "Ayam bakar pedas...", R.drawable.ayam_bakar),
    FoodItem(7, "Ikan Bakar", "Ikan laut segar...", R.drawable.ikan_bakar),
    FoodItem(8, "Bakso Urat", "Bakso daging sapi...", R.drawable.bakso),
    FoodItem(9, "Mie Goreng", "Mie goreng tek-tek...", R.drawable.mie_goreng),
    FoodItem(10, "Capcay", "Berbagai macam sayuran...", R.drawable.capcay)
)


@Composable
fun HomeScreen(
    rootNavController: NavController,
    viewModel: UserViewModel,
    onFoodClicked: () -> Unit
) {

    val username by viewModel.username.collectAsState()

    Scaffold { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 kolom
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {


            item(span = { GridItemSpan(2) }) {
                Column {
                    Text(
                        text = "Halo ${username},",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Makanan",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }


            items(dummyFoodList) { foodItem ->
                FoodItemCard(
                    food = foodItem,
                    onClick = {

                        viewModel.selectFood(foodItem.name)

                        onFoodClicked()
                    }
                )
            }
        }
    }
}


@Composable
fun FoodItemCard(food: FoodItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {

            Image(
                painter = painterResource(id = food.imageResId),
                contentDescription = food.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )


            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = food.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = food.description,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2
                )
            }
        }
    }
}