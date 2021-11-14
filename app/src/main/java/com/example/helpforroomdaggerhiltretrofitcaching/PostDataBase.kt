package com.example.helpforroomdaggerhiltretrofitcaching

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Post::class],version = 1)
abstract class PostDataBase : RoomDatabase() {
    abstract fun postDao() : PostDAO
}