package com.manager.myapplication.model.api

import com.manager.myapplication.model.MyPojo

class ApiHelperImpl(private val apiInterface: ApiInterface): ApiHelper {


    override suspend fun getMessages(): List<MyPojo> = apiInterface.getMessages()


}