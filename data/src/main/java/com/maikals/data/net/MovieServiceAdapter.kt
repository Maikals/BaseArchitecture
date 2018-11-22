package com.maikals.data.net

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.maikals.data.net.interceptor.RequestInterceptor
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MovieServiceAdapter(private val authInterceptor: RequestInterceptor) {

    fun createService(): MostPopularMoviesService {
        val httpClient = Builder()
            .addInterceptor(authInterceptor)
            .connectTimeout(ApiConstants.TIMEOUT_CONNECTION_VALUE, TimeUnit.SECONDS)
            .readTimeout(ApiConstants.TIMEOUT_READ_VALUE, TimeUnit.SECONDS)
            .writeTimeout(ApiConstants.TIMEOUT_WRITE_VALUE, TimeUnit.SECONDS)
        val builder = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
        return builder.client(httpClient.build()).build().create(MostPopularMoviesService::class.java)
    }
}