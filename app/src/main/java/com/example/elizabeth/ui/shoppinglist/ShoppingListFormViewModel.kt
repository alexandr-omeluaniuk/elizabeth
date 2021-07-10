package com.example.elizabeth.ui.shoppinglist

import android.app.Application
import androidx.lifecycle.*
import com.example.elizabeth.database.AppDatabase
import com.example.elizabeth.entity.ShoppingList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ShoppingListFormViewModel(application: Application) : AndroidViewModel(application) {
    val list: MutableLiveData<ShoppingList> by lazy {
        MutableLiveData<ShoppingList>(ShoppingList(0,
            "Новый список от " + SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(Date())
            )
        )
    }
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(list) {
            value = list.value?.isValid()
        }
    }

    fun onSave() {
        val shoppingList = list.value
        if (shoppingList != null) {
            System.out.println("SAVE: " + list.value?.name)
            viewModelScope.launch(Dispatchers.IO) {
                AppDatabase.getInstance(getApplication()).shoppingListDao().insert(shoppingList)
            }
        }
    }
}