package com.example.elizabeth.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.elizabeth.entity.ShoppingList

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM ShoppingList")
    fun getAll(): List<ShoppingList>
    @Insert
    fun insert(shoppingList: ShoppingList)
}