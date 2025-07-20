package com.example.yemekleruygulamasi_.room

import androidx.room.*
import com.example.yemekleruygulamasi_.entity.Yemekler

@Dao
interface YemeklerDao {

    @Query("SELECT * FROM yemekler")
    suspend fun getYemekler(): List<Yemekler>

    @Insert
    suspend fun addYemekler(yemekler: Yemekler)

    @Update
    suspend fun updateYemekler(yemekler: Yemekler)

    @Delete
    suspend fun deleteYemekler(yemekler: Yemekler)
}