package com.example.helpforroomdaggerhiltretrofitcaching

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class AppRepository @Inject constructor(
    private val Appapi: AppApi
){

    suspend fun getpostrepo():List<Post>{
        return Appapi.getposts()
    }

}