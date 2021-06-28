package com.example.elizabeth.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

class ShoppingList(name: String) : BaseObservable() {
    @Bindable
    val name: ObservableField<String> = ObservableField(name);
}