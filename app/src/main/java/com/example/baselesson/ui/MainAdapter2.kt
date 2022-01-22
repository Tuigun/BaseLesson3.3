package com.example.baselesson.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baselesson.databinding.ItemCountBinding
import com.example.baselesson.extension.load

class MainAdapter2(val list: MutableList<String>) :
    RecyclerView.Adapter<MainAdapter2.ViewHolder>() {

    private lateinit var onClick: OnClick
    fun setOnClick(onClick: OnClick) {
        this.onClick = onClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter2.ViewHolder {
        return ViewHolder(
            ItemCountBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainAdapter2.ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private var binding: ItemCountBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var onClick: OnClick
        fun onBind(s: String) {
            binding.image.load(s)
            itemView.setOnClickListener {
                if (binding.teal.visibility == View.GONE) {
                    onClick.onClick(s)
                    binding.teal.visibility = View.VISIBLE
                } else {
                    binding.teal.visibility = View.GONE
                    onClick.onDelete(s)
                }

            }

        }
    }
}