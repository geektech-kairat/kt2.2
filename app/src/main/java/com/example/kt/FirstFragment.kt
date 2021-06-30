package com.example.kt


import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.kt.adapters.RecyclerViewMain
import com.example.kt.databinding.FragmentFirstBinding
import com.example.kt.models.Image
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirstFragment : Fragment() {
    private val listIsUri = arrayListOf<Image>()
    private lateinit var adapter: RecyclerViewMain
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        click()
        setList()
        adapter = RecyclerViewMain(listIsUri)
        binding.rv.adapter = adapter
        binding.search.setOnQueryTextListener(object : SearchView(context),
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }

        })
        return binding.root
    }

    private fun setList() {
        listIsUri.add(Image("kot", "https://klike.net/uploads/posts/2019-01/1547367999_1.jpg"))
        listIsUri.add(
            Image(
                "koot",
                "https://total.kz/storage/99/9991b47e22a28280965a12d05e476a9d_resize_w_830_h_465.jpg"
            )
        )
        listIsUri.add(
            Image(
                "kooot",
                "https://tn.fishki.net/26/upload/post/2019/09/20/3091342/1568622623-5.jpg"
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

    private fun glide() {

//        listIsUri.shuffle()
//        binding.image.loadImage(listIsUri[0])

//        binding.progressBar.visibility = View.VISIBLE
//        CoroutineScope(Dispatchers.IO).launch {
//
//        }
//        binding.progressBar.visibility = View.INVISIBLE


    }

    private fun click() {
        binding.fabSend.setOnClickListener {
            glide()
        }
    }
}




