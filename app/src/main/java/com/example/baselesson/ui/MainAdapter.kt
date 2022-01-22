package com.example.baselesson.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baselesson.databinding.ItemCountBinding
import com.example.baselesson.extension.load


class MainAdapter(val list: MutableList<String>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private lateinit var onClick: OnClick
    fun setOnClick(onClick: OnClick) {
        this.onClick = onClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size


   inner class ViewHolder(private var binding: ItemCountBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun onBind(s: String) {
            binding.image.load(s)
            itemView.setOnClickListener {
                if (binding.container.visibility == View.GONE) {
                    onClick.onClick(s)
                    binding.container.visibility = View.VISIBLE
                } else {
                    binding.container.visibility = View.GONE
                    onClick.onDelete(s)
                }
            }



        }

    }



}
