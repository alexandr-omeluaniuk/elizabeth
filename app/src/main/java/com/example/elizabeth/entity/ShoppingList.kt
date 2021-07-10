package com.example.elizabeth.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingList(
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "name") var name: String
) {
    fun isValid(): Boolean {
        return name.isNotEmpty()
    }
}