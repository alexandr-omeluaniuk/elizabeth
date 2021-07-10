package com.example.elizabeth.ui.shoppinglist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elizabeth.model.ShoppingList
import java.text.SimpleDateFormat
import java.util.*

class ShoppingListFormViewModel : ViewModel() {
    val list: MutableLiveData<ShoppingList> by lazy {
        MutableLiveData<ShoppingList>(ShoppingList(
            "Новый список от "
                    + SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(Date())
        ))
    }
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(list) {
            value = list.value?.isValid()
        }
    }

    fun onSave() {
        System.out.println("SAVE: " + list.value?.name)
    }

}