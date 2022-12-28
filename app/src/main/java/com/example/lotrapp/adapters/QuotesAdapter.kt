package com.example.lotrapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lotrapp.R
import com.example.lotrapp.models.Quote

class QuotesAdapter : RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>() {

    class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    private val differCallBack = object  : DiffUtil.ItemCallback<Quote>(){
        override fun areItemsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Quote, newItem: Quote): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,differCallBack)
    val list: ArrayList<Quote> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<Quote>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        return QuotesAdapter.QuoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_quote,
                parent,
                false

            )
        )
    }


    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quote = differ.currentList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.quoteTv).text = quote.dialog
            findViewById<TextView>(R.id.charNameTv).text = quote.character
            findViewById<TextView>(R.id.movieNameTv).text = quote.movie
        }
    }

        override fun getItemCount(): Int {
            return differ.currentList.size
        }
    }
