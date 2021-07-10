package com.example.elizabeth.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.elizabeth.entity.ShoppingListEntity

@Dao
interface ShoppingListDao {
    @Query("SELECT * FROM ShoppingListEntity")
    fun getAll(): List<ShoppingListEntity>
    @Insert
    fun insert(shoppingList: ShoppingListEntity)
}