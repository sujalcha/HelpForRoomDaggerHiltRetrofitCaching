package com.example.helpforroomdaggerhiltretrofitcaching

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PostTable")
data class Post(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "PostUserId")
    val userId: Int,

    @ColumnInfo(name = "PostTitle")
    val title: String,

    //try without column info
    val body: String
)