package com.example.kt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kt.baseClass.loadImage
import com.example.kt.databinding.ItemRecyclerMainBinding
import com.example.kt.models.Image

class RecyclerViewMain(private val list: List<Image>) :
    RecyclerView.Adapter<RecyclerViewMain.ViewHolderMain>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMain {
        return ViewHolderMain(
            ItemRecyclerMainBinding.inflate
                (
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolderMain, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolderMain(private val binding: ItemRecyclerMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(image: Image) {
            binding.imageItem.loadImage(image.url)
            binding.textViewItem.text = image.name
            binding.imageItem.setOnClickListener {
                Toast.makeText(binding.root.context, image.name, Toast.LENGTH_SHORT).show()
            }

        }

    }
}
