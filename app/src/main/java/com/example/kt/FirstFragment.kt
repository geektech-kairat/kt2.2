package com.example.kt


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kt.adapters.RecyclerViewMain
import com.example.kt.databinding.FragmentFirstBinding
import com.example.kt.models.Image

class FirstFragment : Fragment() {
    private val listIsUri = arrayListOf<Image>()
    private lateinit var adapter: RecyclerViewMain
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)

        setList()
        adapter = RecyclerViewMain(listIsUri)
        binding.rv.adapter = adapter
        binding.search.setOnQueryTextListener(object : SearchView(context),
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.search.clearFocus()

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText.toString())
                return false
            }

        })
        return binding.root
    }

    private fun setList() {



        listIsUri.add(Image("panda", "https://ichef.bbci.co.uk/news/640/cpsprodpb/8D5E/production/_102609163_animals1.jpg"))
        listIsUri.add(
            Image(
                "кот",
                "https://user30887.clients-cdnnow.ru/uploads/5f42be1ca1de1006829794.jpg"
            )
        )
        listIsUri.add(
            Image(
                "тигр",
                "https://i.pinimg.com/originals/46/48/92/4648926bf00a30ca544034d035451dd3.jpg"
            )
        )
        listIsUri.add(
            Image("leon",

                "https://regnum.ru/uploads/pictures/news/2018/05/24/regnum_picture_1527141799912130_normal.png"
            )
        )
        listIsUri.add(
            Image(
                "dog ",
                "https://www.ferra.ru/thumb/1800x0/filters:quality(75):no_upscale()/imgs/2021/05/10/10/4656915/d724e9a965f46bec94a9731f47d2241d53921ce4.jpg"
            )
        )
        listIsUri.add(
            Image(
                "крыса",
                "https://cdn-st1.rtr-vesti.ru/vh/pictures/xw/317/277/6.jpg"
            )
        )
        listIsUri.add(
            Image(
                "короз",
                "https://zooclub.ru/attach/53000/53493.jpg"
            )
        )
        listIsUri.add(
            Image(
                "kooot",
                "https://avatars.mds.yandex.net/get-znatoki/1368855/2a0000017309198dde0ee144864021ca9af1/w480"
            )
        )
        listIsUri.add(
            Image(
                "kooot",
                "https://avatars.mds.yandex.net/get-znatoki/1368855/2a0000017309198dde0ee144864021ca9af1/w480"
            )
        )
    }
    private fun filter(text: String) {
        val newList: ArrayList<Image> = ArrayList()
        for (i in listIsUri){
            if (i.name.contains(text)){
                newList.add(i)
            }
        }
        adapter.setFilter(newList)
    }
}




