package com.example.elizabeth.ui.shoppinglist

import androidx.lifecycle.*
import com.example.elizabeth.entity.ShoppingList
import java.text.SimpleDateFormat
import java.util.*

class ShoppingListFormViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val list: MutableLiveData<ShoppingList> by lazy {
        MutableLiveData<ShoppingList>(ShoppingList(0,
            "Новый список от "
                    + SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(Date())
        )
        )
    }
    val valid = MediatorLiveData<Boolean>().apply {
        addSource(list) {
            value = list.value?.isValid()
        }
    }

    fun onSave() {
        System.out.println("SAVE: " + list.value?.name)
//        val context = viewModelScope.coroutineContext;
//        if (context != null) {
//            AppDatabase.getInstance(context).shoppingListDao().insert(entity);
//        }
    }
}