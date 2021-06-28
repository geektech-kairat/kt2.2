package com.example.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kt.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        getBundle()
        click()
        return binding.root
    }

    private fun click() {
        binding.fabSend.setOnClickListener {
            if (binding.textEditText.text.toString().trim() != "") {
                val bundle = Bundle()
                bundle.putString("myArgs", binding.textEditText.text.toString())
                findNavController().navigate(R.id.action_secondFragment_to_firstFragment, bundle)
            } else {
                Toast.makeText(requireContext(), "Введите текст !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getBundle() {
        val text = arguments?.getString("myArgs")
        binding.textEditText.setText(text)
    }
}