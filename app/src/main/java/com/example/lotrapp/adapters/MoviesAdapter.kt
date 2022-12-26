package com.example.lotrapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lotrapp.R
import com.example.lotrapp.models.Movie
import kotlin.math.roundToInt
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object  : DiffUtil.ItemCallback<Movie>(){
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = differ.currentList[position]
        holder.itemView.findViewById<TextView>(R.id.movieNameTv).text = movie.name
        holder.itemView.findViewById<TextView>(R.id.runtimeTv).text = movie.runtimeInMinutes?.toDuration(DurationUnit.MINUTES).toString()
        val score = movie.rottenTomatoesScore?.roundToInt().toString()+"%"
        holder.itemView.findViewById<TextView>(R.id.scoreTv).text = score
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}