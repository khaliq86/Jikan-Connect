package com.example.jikanconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation

class MainAdapter(private val animeList: List<Anime>) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val anime = animeList[position]
        holder.bind(anime)
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textView)
        private val durationTextView: TextView = itemView.findViewById(R.id.duration)
        private val synopsisTextView: TextView = itemView.findViewById(R.id.synopsis)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)

        fun bind(anime: Anime) {
            nameTextView.text = anime.name
            durationTextView.text = anime.duration
            synopsisTextView.text = anime.synopsis
            imageView.load(anime.images.jpg.image_url) {
                transformations(CircleCropTransformation())
            }
        }
    }
}
