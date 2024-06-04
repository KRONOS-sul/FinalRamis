package com.example.finalramis.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalramis.OnItemClick
import com.example.finalramis.R
import com.example.finalramis.adapter.CharacterAdapter
import com.example.finalramis.databinding.FragmentCharactersBinding
import com.example.finalramis.entities.CharacterEntity

class CharactersFragment : Fragment(), OnItemClick {

    private lateinit var binding: FragmentCharactersBinding
    private val rvList = ArrayList<CharacterEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadList()
        val adapter = CharacterAdapter(rvList, this)
        binding.charactersRv.adapter = adapter
    }

    private fun loadList() {
        rvList.add(
            CharacterEntity(
                "https://static.wikia.nocookie.net/onepunchman/images/2/25/Saitama_Icon.png/revision/latest/scale-to-width-down/144?cb=20190921065915",
                "Saitama",
                "Alive"
            )
        )
        rvList.add(
            CharacterEntity(
                "https://static.wikia.nocookie.net/onepunchman/images/c/c5/King_Icon.jpg/revision/latest/scale-to-width-down/144?cb=20230612120613",
                "King",
                "Alive"
            )
        )
        rvList.add(
            CharacterEntity(
                "https://static.wikia.nocookie.net/onepunchman/images/d/dd/Genos_Manga_Icon.png/revision/latest/scale-to-width-down/144?cb=20230827035953",
                "Genos",
                "Alive"
            )
        )
    }

    override fun onItemClick(character: CharacterEntity) {
        findNavController().navigate(
            R.id.characterDetailsFragment, bundleOf("character" to character)
        )
    }

}