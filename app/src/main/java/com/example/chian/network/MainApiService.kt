package com.example.chian.network

import com.example.bumpercar.data.CarResponseData
import com.example.bumpercar.data.MessageData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MainApiService {
    @POST("chian")
    suspend fun postDriveJudge(
        @Body query: MessageData
    ) : Response<CarResponseData>
}