package com.example.secureofflineexpense.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.secureofflineexpense.data.model.Expense

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAll(): LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expense: Expense): Long

    @Delete
    suspend fun delete(expense: Expense)
}
