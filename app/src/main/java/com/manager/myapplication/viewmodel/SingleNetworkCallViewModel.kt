package com.manager.myapplication.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manager.myapplication.model.MyPojo
import com.manager.myapplication.model.api.ApiHelper
import kotlinx.coroutines.launch
import java.lang.Exception

class RetroViewModel(private val apiHelper: ApiHelper, private val context: Context) : ViewModel(){

    private val message = MutableLiveData<List<MyPojo>>()


    fun fetchMessage() {
        viewModelScope.launch {
            try {
                val messages = apiHelper.getMessages()
                message.postValue(messages)
            }catch (e:Exception){
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        }
    }



    fun getMessage(): LiveData<List<MyPojo>>{
        return message
    }

}