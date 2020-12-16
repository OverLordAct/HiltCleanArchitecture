package com.joydeep.hiltcleanarchitecture.common.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.joydeep.data.api.Api
import com.joydeep.data.repositoryImpl.UserRepositoryImpl
import com.joydeep.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    private val baseUrl = "https://reqres.in"

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit.Builder): Api {
        return retrofit.build().create(Api::class.java)
    }

    @Singleton
    @Provides
    fun providesUserRepository(userRepository: UserRepositoryImpl): UserRepository {
        return userRepository
    }
}