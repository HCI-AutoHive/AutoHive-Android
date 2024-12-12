package com.example.chian.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object { // 객체 생성 없이 사용할 수 있도록 함

        // 자신 로컬 서버 주소로 호출할려면 10.0.2.2를 사용하기
        private const val mainURL = "http://10.0.2.2:5000/api/"

        private var mainApiService: MainApiService? = null

        fun getChatApi(): MainApiService {
            if (mainApiService == null) {

                val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(120, TimeUnit.SECONDS)
                    .readTimeout(120, TimeUnit.SECONDS)
                    .writeTimeout(120, TimeUnit.SECONDS)
                    .build()

                val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

                mainApiService = Retrofit.Builder()
                    .baseUrl(mainURL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .client(okHttpClient)
                    .build()
                    .create(MainApiService::class.java) // IApiService 인터페이스를 사용할 수 있도록 생성
            }
            return mainApiService!! // apiService가 null이 아닌 경우 반환
        }
    }
}