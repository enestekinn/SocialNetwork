package com.enestekin.socialnetwork.di

import com.enestekin.socialnetwork.feature_profile.data.remote.ProfileApi
import com.enestekin.socialnetwork.feature_profile.data.repository.ProfileRepositoryImpl
import com.enestekin.socialnetwork.feature_profile.domain.repository.ProfileRepository
import com.enestekin.socialnetwork.feature_profile.domain.use_case.GetProfileUseCase
import com.enestekin.socialnetwork.feature_profile.domain.use_case.ProfileUseCases
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
object ProfileModule {

    @Provides
    @Singleton
    fun provideProfileApi(client: OkHttpClient): ProfileApi {
        return Retrofit.Builder()
            .baseUrl(ProfileApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ProfileApi::class.java)

    }

    @Provides
    @Singleton
    fun profileRepository(api: ProfileApi): ProfileRepository {
        return ProfileRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideProfileUseCases(repository: ProfileRepository): ProfileUseCases{
        return ProfileUseCases(
            getProfile = GetProfileUseCase(repository)
        )
    }
}


