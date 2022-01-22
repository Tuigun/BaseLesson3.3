package com.example.baselesson.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baselesson.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var adapter2: MainAdapter2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = intent.getStringArrayListExtra("key")
        binding.recycler.adapter = list.let { it?.let { it1 -> MainAdapter2(it1) } }
        binding.ivBack.setOnClickListener{
            finish()

        }
    }

}