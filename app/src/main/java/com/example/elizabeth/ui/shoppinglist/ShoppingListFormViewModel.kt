package com.example.elizabeth.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elizabeth.model.ShoppingList
import com.example.elizabeth.util.ObservableViewModel

class ShoppingListFormViewModel : ObservableViewModel() {
    private val _list: MutableLiveData<ShoppingList> by lazy {
        MutableLiveData<ShoppingList>(ShoppingList(""))
    }
    val list: MutableLiveData<ShoppingList> = _list
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