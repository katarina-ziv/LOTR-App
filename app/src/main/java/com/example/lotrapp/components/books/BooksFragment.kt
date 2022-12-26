package com.example.lotrapp.components.books


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotrapp.activities.MainActivity
import com.example.lotrapp.activities.MainViewModel
import com.example.lotrapp.adapters.BooksAdapter
import com.example.lotrapp.databinding.FragmentBooksBinding
import com.example.lotrapp.services.utils.Resource


class BooksFragment : Fragment() {

    private lateinit var binding: FragmentBooksBinding
    lateinit var viewModel: MainViewModel
    lateinit var bookAdapter: BooksAdapter


    val TAG = "BooksFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBooksBinding.inflate(layoutInflater, container, false)
        Log.i("BooksFragment", "onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.books.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { booksResponse ->
                        bookAdapter.differ.submitList(booksResponse.docs)

                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->

                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }

        })
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        bookAdapter = BooksAdapter()
        binding.booksRv.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(activity)
            Log.i("BooksFragment", "rec view")
        }
    }

}