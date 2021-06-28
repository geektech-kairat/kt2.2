package com.example.kt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kt.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        click()
        getBundle()
        return binding.root
    }
    private fun getBundle() {
        val text = arguments?.getString("myArgs")
        binding.textEditText.setText(text)
    }

    private fun click() {
        binding.fabSend.setOnClickListener {
          if (binding.textEditText.text.toString().trim() != ""){
              val bundle = Bundle()
              bundle.putString("myArgs", binding.textEditText.text.toString())
              findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
          }else{
              Toast.makeText(requireContext(), "Введите текст !", Toast.LENGTH_SHORT).show()
          }
        }
    }


}