package com.example.elizabeth.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elizabeth.model.ShoppingList
import com.example.elizabeth.util.ObservableViewModel

class ShoppingListFormViewModel : ViewModel() {
    val list: MutableLiveData<ShoppingList> by lazy {
        MutableLiveData<ShoppingList>(ShoppingList(""))
    }
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(list) {
            value = list.value?.isValid()
        }
    }

    fun onSave() {
        System.out.println("SAVE: " + list.value?.name);
    }

}