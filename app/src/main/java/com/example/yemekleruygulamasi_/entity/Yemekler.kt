package com.example.yemekleruygulamasi_.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "yemekler")
data class Yemekler(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "yemek_id") @NotNull var yemek_id: Int,
    @ColumnInfo(name = "yemek_ad") @NotNull var yemek_ad: String,
    @ColumnInfo(name = "yemek_fiyat") @NotNull var yemek_fiyat: Int
)