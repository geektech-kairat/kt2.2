package com.example.kt.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kt.baseClass.loadImage
import com.example.kt.databinding.ItemRecyclerMainBinding
import com.example.kt.models.Image

class RecyclerViewMain(private val list: ArrayList<Image>) :
    RecyclerView.Adapter<RecyclerViewMain.ViewHolderMain>() {

    private var _list: ArrayList<Image> = list


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
        holder.onBind(_list[position])
    }

    override fun getItemCount(): Int {
        return _list.size
    }

    fun setFilter(newList: ArrayList<Image>){
        this._list = newList
        notifyDataSetChanged()
    }

    fun delete(pos: Int){
        this._list.removeAt(pos)
        notifyItemRemoved(pos)
    }





   inner class ViewHolderMain(private val binding: ItemRecyclerMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(image: Image) {

            binding.imageItem.loadImage(image.url)
            binding.textViewItem.text = image.name
            binding.imageItem.setOnClickListener {
                Toast.makeText(binding.root.context, image.name, Toast.LENGTH_SHORT).show()
            }
            binding.imageItem.setOnLongClickListener {
                delete(position)
                true }

        }

    }
}
