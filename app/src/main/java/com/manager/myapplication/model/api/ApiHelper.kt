package com.manager.myapplication.model.api

import com.manager.myapplication.model.MyPojo

interface ApiHelper {

    suspend fun getMessages(): List<MyPojo>
}