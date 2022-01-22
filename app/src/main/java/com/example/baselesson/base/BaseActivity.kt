package com.example.baselesson.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

class BaseActivity<VB:ViewBinding>: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initListener()
        checkInternet()
        initViewModel()
    }
    open fun initView(){}
    open fun initListener(){}
    open fun checkInternet(){}
    open fun initViewModel(){}

}