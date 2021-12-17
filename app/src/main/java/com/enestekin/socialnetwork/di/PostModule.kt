package com.enestekin.socialnetwork.di

import com.enestekin.socialnetwork.core.domain.data.remote.PostApi
import com.enestekin.socialnetwork.feature_post.data.repository.PostRepositoryImpl
import com.enestekin.socialnetwork.feature_post.domain.repository.PostRepository
import com.enestekin.socialnetwork.feature_post.domain.use_case.CreatePostUseCase
import com.enestekin.socialnetwork.feature_post.domain.use_case.GetPostsForFollowsUseCase
import com.enestekin.socialnetwork.feature_post.domain.use_case.PostUseCases
import com.google.gson.Gson
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
object PostModule {

    @Provides
    @Singleton
    fun providePostApi(client: OkHttpClient): PostApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(PostApi.BASE_URL)
            .client(client)
            .build()
            .create(PostApi::class.java)
    }


    @Provides
    @Singleton
    fun providePostRepository(
        api: PostApi,
        gson: Gson,
    ): PostRepository {
        return PostRepositoryImpl(api,gson)
    }

    @Provides
    @Singleton
    fun providePostUseCases(repository: PostRepository): PostUseCases {
        return PostUseCases(
            getPostsForFollowsUserCase = GetPostsForFollowsUseCase(repository),
            createPostUseCase = CreatePostUseCase(repository)
        )
    }
}