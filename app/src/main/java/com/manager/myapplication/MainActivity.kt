package com.manager.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.manager.myapplication.model.MyPojo
import com.manager.myapplication.utils.Status
import com.manager.myapplication.viewmodel.SingleNetworkCallViewModel


class MainActivity : AppCompatActivity() {

    private var progressDialog: ProgressDialog? = null
    private lateinit var messageTv: TextView
    private lateinit var networkViewModel: SingleNetworkCallViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initProgressDialog()
        initViewModel()
        initApiCall()
    }

    private fun initViews() {
        messageTv = findViewById(R.id.tv_load)
    }

    private fun initProgressDialog() {
        progressDialog = ProgressDialog(this);
        progressDialog?.setMessage("Loading, message..")
    }

    private fun initViewModel() {
        networkViewModel = ViewModelProviders.of(this).get(SingleNetworkCallViewModel::class.java)
    }

    private fun initApiCall() {
        networkViewModel.getMessage().observe(this, Observer {
            when(it.status){
                Status.LOADING -> progressDialog?.show()
                Status.SUCCESS -> {
                    it.data?.let { messages -> renderUI(messages) }
                    progressDialog?.dismiss()
                }
                Status.ERROR -> {
                    it.message?.let { message -> renderfailedUI(message) }
                    progressDialog?.dismiss()
                }
            }
        })

        //fetch messages
        networkViewModel.fetchMessage()
    }

    private fun renderfailedUI(message: String) {
        messageTv.text = message
    }

    private fun renderUI(messages: List<MyPojo>) {
        messageTv.text = messages[0].name
    }

}
