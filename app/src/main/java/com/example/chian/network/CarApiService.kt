package com.example.chian.network

import com.example.chian.data.CarDetailData
import com.example.chian.data.CarsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarApiService {
    @GET("cars")
    suspend fun getCars() : List<CarsData>
    @GET("cars/{carId}/detail")
    suspend fun getDetails(
        @Path("carId") carId: Int
    ) : CarDetailData
}