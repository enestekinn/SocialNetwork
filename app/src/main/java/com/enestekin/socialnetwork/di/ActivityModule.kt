package com.enestekin.socialnetwork.di

import com.enestekin.socialnetwork.feature_activity.data.remote.ActivityApi
import com.enestekin.socialnetwork.feature_activity.data.repository.ActivityRepositoryImpl
import com.enestekin.socialnetwork.feature_activity.domain.repository.ActivityRepository
import com.enestekin.socialnetwork.feature_activity.domain.use_case.GetActivityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ActivityModule {


    @Provides
    @Singleton
    fun provideActivityApi(client: OkHttpClient): ActivityApi {
        return Retrofit.Builder()
            .baseUrl(ActivityApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ActivityApi::class.java)
    }


    @Provides
    @Singleton
    fun provideActivityRepository(api: ActivityApi): ActivityRepository{
        return ActivityRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetActivitiesUseCase(repository: ActivityRepository): GetActivityUseCase{
        return GetActivityUseCase(repository)
    }
}