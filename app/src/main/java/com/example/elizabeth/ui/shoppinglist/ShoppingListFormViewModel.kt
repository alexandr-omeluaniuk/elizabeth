package com.example.elizabeth.ui.shoppinglist

import androidx.lifecycle.*
import com.example.elizabeth.database.AppDatabase
import com.example.elizabeth.entity.ShoppingListEntity
import com.example.elizabeth.model.ShoppingList
import java.text.SimpleDateFormat
import java.util.*

class ShoppingListFormViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
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
        val entity: ShoppingListEntity = ShoppingListEntity(0, list.value?.name)
//        val context = viewModelScope.coroutineContext;
//        if (context != null) {
//            AppDatabase.getInstance(context).shoppingListDao().insert(entity);
//        }
    }
}