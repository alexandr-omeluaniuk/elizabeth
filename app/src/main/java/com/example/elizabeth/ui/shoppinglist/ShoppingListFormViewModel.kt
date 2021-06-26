package com.example.elizabeth.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elizabeth.model.ShoppingList

class ShoppingListFormViewModel : ViewModel() {
    private val _list = MutableLiveData<ShoppingList>().apply {
        value = ShoppingList("");
    }
    val list: LiveData<ShoppingList> = _list
}