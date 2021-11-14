package com.example.helpforroomdaggerhiltretrofitcaching

import retrofit2.http.GET


interface AppApi {

    @GET("/Posts")
    suspend fun getposts(): List<Post>

}