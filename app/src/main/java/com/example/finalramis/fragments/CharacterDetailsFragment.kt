package com.example.finalramis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.finalramis.databinding.FragmentCharactersDetailsBinding
import com.example.finalramis.entities.CharacterEntity

class CharacterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCharactersDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharactersDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character =
            requireArguments().getString("character")

    }

}