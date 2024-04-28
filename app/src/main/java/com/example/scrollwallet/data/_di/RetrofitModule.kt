package com.example.scrollwallet.data._di

import com.example.scrollwallet.data.network.RequestHeaderInterceptor
import com.example.scrollwallet.data.network.api.BaseApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideRequestHeaderInterceptor(): RequestHeaderInterceptor {
        return RequestHeaderInterceptor()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        requestHeaderInterceptor: RequestHeaderInterceptor
    ): OkHttpClient {
        try {
            val builder = OkHttpClient.Builder()
                .connectTimeout(30L, TimeUnit.SECONDS)
                .readTimeout(30L, TimeUnit.SECONDS)
                .writeTimeout(30L, TimeUnit.SECONDS)
                .addInterceptor(requestHeaderInterceptor)
             builder.addInterceptor(httpLoggingInterceptor)
           // if (BuildConfig.DEBUG) builder.addInterceptor(httpLoggingInterceptor)
            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    @Provides
    @Singleton
    fun w(okHttpClient: OkHttpClient): BaseApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(getBaseUri())
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(BaseApi::class.java)
    }


    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun getBaseUri(): String = "https://api.covalenthq.com/v1/"

}