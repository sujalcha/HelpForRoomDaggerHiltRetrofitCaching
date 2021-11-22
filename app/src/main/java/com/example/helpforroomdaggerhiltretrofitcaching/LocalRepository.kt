package com.example.helpforroomdaggerhiltretrofitcaching

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ActivityScoped
class LocalRepository @Inject constructor(
    private val apprepository: AppRepository,
    private val db: PostDataBase
) {
    init {

    }

    @OptIn(ExperimentalAnimationApi::class)
    suspend fun getpost(): List<Post> {

        var alldata = db.postDao().displayAllPosts()


        try {
            var result = apprepository.getpostrepo()


            for (item in result) {
                val post = Post(item.id, item.userId, item.title, item.body)
                db.postDao().deletepost(post)
                db.postDao().insertpost(post)
            }
            alldata = db.postDao().displayAllPosts()

        } catch (e: HttpException) {

            Log.e("http excpetion, error", "http excpetion, error")
        } catch (e: IOException) {
            Log.e("http excpetion, error", "http excpetion, error")
        }

        return alldata
    }
}