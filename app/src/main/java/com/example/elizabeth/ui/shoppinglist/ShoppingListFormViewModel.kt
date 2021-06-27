package com.example.elizabeth.ui.shoppinglist

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elizabeth.model.ShoppingList

class ShoppingListFormViewModel : ViewModel() {
    private val _list = MutableLiveData<ShoppingList>().apply {
        value = ShoppingList("");
    }
    val list: LiveData<ShoppingList> = _list
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(list) {
            System.out.println("FIRE");
            value = false
        }
    }

    fun validation(): Boolean {
        var passed = true;

        return passed;
    }

    fun onSave() {
        if (validation()) {
            System.out.println("SAVE: " + list.value?.name);
        }
    }

}