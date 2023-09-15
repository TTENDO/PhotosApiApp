package com.ttendo.photosapiapp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance{

    fun createOkHttpClient():OkHttpClient{
        //create a logger
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    fun initialiseService():PhotoInterface{
        val okClient = createOkHttpClient()
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .client(okClient).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(PhotoInterface::class.java)
    }
}