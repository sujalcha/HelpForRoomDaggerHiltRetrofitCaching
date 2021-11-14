package com.example.helpforroomdaggerhiltretrofitcaching

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

const val URL = "https://jsonplaceholder.typicode.com/"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRetrofitInstance(): AppApi {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppApi::class.java)
    }

    @Provides
    @Singleton
    fun getpostrepository(api: AppApi) = AppRepository(api)

    @Provides
    @Singleton
    fun getdbrepository(appRepository: AppRepository,dataBase: PostDataBase) = LocalRepository(appRepository,dataBase)

    @Provides
    @Singleton
    fun provideDatabase(app: Application) : PostDataBase =
        Room.databaseBuilder(app, PostDataBase::class.java, "post_database")
            .build()

}