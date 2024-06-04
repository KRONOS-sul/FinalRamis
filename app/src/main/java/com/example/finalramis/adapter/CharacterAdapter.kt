package com.example.finalramis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalramis.OnItemClick
import com.example.finalramis.R
import com.example.finalramis.entities.CharacterEntity

class CharacterAdapter(
    private val characters: ArrayList<CharacterEntity>, private val onItemClick: OnItemClick
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(characters[position])
        holder.itemView.setOnClickListener {
            onItemClick.onItemClick(characters[position])
        }
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val avatar: ImageView = itemView.findViewById(R.id.avatar_item_img)
        private val name: TextView = itemView.findViewById(R.id.name_item_tv)
        private val status: TextView = itemView.findViewById(R.id.status_item_tv)

        fun onBind(character: CharacterEntity) {
            Glide.with(avatar).load(character.avatar).into(avatar)
            name.text = character.name
            status.text = character.status
        }

    }
}