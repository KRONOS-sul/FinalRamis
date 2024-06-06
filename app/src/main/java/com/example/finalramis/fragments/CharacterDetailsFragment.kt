package com.example.finalramis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.finalramis.databinding.FragmentCharactersDetailsBinding

class CharacterDetailsFragment : Fragment() {
    private lateinit var binding: FragmentCharactersDetailsBinding
    private lateinit var safeArgs: CharacterDetailsFragmentArgs

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
        arguments?.let {
            safeArgs = CharacterDetailsFragmentArgs.fromBundle(it)
        }
        with(binding) {
            Glide.with(avatarImg).load(safeArgs.character.avatar).into(avatarImg)
            nameTv.text = safeArgs.character.name
            statusTv.text = safeArgs.character.status
        }

    }

}