package com.example.baselesson.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.baselesson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapterM: MainAdapter
    val list = mutableListOf<String>()
    val list2 = arrayListOf<String>()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        binding.btnSent.setOnClickListener {
            initIntent()
        }
        adapterM.setOnClick(object : OnClick {
            override fun onClick(position: String) {
                list2.add(position)

            }

            override fun onDelete(position: String) {
                list2.remove(position)
            }
        })

    }

    private fun initIntent() {
        Intent(this, MainActivity2::class.java).apply {
            putStringArrayListExtra("key", list2)
            startActivity(this)
        }

    }

    private fun setList(): MutableList<String> {
        for (i in 1..100) {
            list.add("https://i.pinimg.com/564x/83/e1/6f/83e16fb412bae1cbf1b8adbf14d185f9.jpg")
        }
        return list

    }

    private fun initAdapter() {

        with(binding.recycler) {
            adapterM = MainAdapter(setList())
            adapter = adapterM
        }
    }
}