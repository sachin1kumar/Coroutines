package com.manager.myapplication.model.api

import com.manager.myapplication.model.MyPojo
import retrofit2.http.GET

interface ApiInterface{

    @GET("mycoroutines")
    suspend fun getMessages(): List<MyPojo>
}