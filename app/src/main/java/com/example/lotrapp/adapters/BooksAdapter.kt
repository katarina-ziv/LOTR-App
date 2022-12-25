package com.example.lotrapp.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lotrapp.R
import com.example.lotrapp.models.Book

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

inner class BookViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)

    private val differCallBack = object : DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_book,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = differ.currentList[position]
        holder.itemView.findViewById<TextView>(R.id.book_title).text = book.name
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}