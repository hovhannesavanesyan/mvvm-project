package com.example.mvvm.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.net.SocketFactory

object NetworkProviderFactory {

    private const val BASE_URL = "https://picsum.photos/v2/" // Fixme need to move on gradle properties

    private val okHttpClientBuilder by lazy {
        OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .socketFactory(SocketFactory.getDefault())
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
    }

    private val baseOkHttpClient = okHttpClientBuilder.build()

    private val baseInterceptorOkHttpClient: OkHttpClient = baseOkHttpClient.newBuilder().build()

    private val gsonConverterFactory: Converter.Factory = GsonConverterFactory.create(GsonBuilder().create())

    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(baseInterceptorOkHttpClient)
        .addConverterFactory(gsonConverterFactory)

    private val retrofit = retrofitBuilder.build()

    private val mainApi by lazy {
        retrofit.create(MainApiService::class.java)
    }

    fun createMainApi(): MainApiService {
        return mainApi
    }
}