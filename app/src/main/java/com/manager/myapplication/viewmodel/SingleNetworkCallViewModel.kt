package com.manager.myapplication.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manager.myapplication.model.MyPojo
import com.manager.myapplication.model.api.ApiHelper
import com.manager.myapplication.model.api.ApiHelperImpl
import com.manager.myapplication.model.api.RetrofitBuilder
import com.manager.myapplication.utils.Resource
import kotlinx.coroutines.launch
import java.lang.Exception

class SingleNetworkCallViewModel : ViewModel(){

    private val message = MutableLiveData<Resource<List<MyPojo>>>()

    fun fetchMessage() {
        val apiHelper = ApiHelperImpl(RetrofitBuilder.apiInterface)
        viewModelScope.launch {
            message.postValue(Resource.loading(null))
            try {
                val messages = apiHelper.getMessages()
                message.postValue(Resource.success(messages))
            } catch (e:Exception){
                message.postValue(Resource.error("Something went wrong!",null))
            }
        }
    }

    fun getMessage(): LiveData<Resource<List<MyPojo>>>{
        return message
    }

}