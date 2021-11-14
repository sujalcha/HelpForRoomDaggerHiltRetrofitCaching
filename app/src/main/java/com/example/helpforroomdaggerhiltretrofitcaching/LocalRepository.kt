package com.example.helpforroomdaggerhiltretrofitcaching

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class LocalRepository @Inject constructor(
    private val apprepository: AppRepository,
    private val db: PostDataBase
) {
    suspend fun getpost():List<Post> {

        //if(isconnected){
        var result = apprepository.getpostrepo()

        for (item in result) {
            val post = Post(item.id, item.userId, item.title, item.body)
            db.postDao().insertpost(post)
        }
        // }


            return db.postDao().displayAllPosts()
    }
}