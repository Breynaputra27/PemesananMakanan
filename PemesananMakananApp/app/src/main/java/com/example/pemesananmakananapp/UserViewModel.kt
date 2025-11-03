package com.example.pemesananmakananapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class UserViewModel : ViewModel() {


    private val _username = MutableStateFlow<String>("Nazwa")


    val username: StateFlow<String> = _username.asStateFlow()


    fun login(name: String) {
        if (name.isNotBlank()) {
            _username.value = name
        }
    }
    private val _selectedFoodName = MutableStateFlow<String?>(null)


    val selectedFoodName: StateFlow<String?> = _selectedFoodName.asStateFlow()


    fun selectFood(foodName: String) {
        _selectedFoodName.value = foodName
    }


    fun clearSelectedFood() {
        _selectedFoodName.value = null
    }
}