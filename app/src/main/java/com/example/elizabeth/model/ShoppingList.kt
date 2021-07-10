package com.example.elizabeth.model

class ShoppingList(var name: String) {

    fun isValid(): Boolean {
        return name.isNotEmpty()
    }
}