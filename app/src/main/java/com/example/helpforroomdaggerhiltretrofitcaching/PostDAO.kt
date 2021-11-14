package com.example.helpforroomdaggerhiltretrofitcaching

import androidx.room.*

@Dao
interface PostDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertpost(post: Post)

    @Delete
    fun deletepost(post: Post)

    @Query("SELECT * FROM posttable")
    fun displayAllPosts(): List<Post>

    @Query("SELECT * FROM posttable WHERE id IN(:postid)")
    fun displayPostsById(postid:IntArray): List<Post>

}