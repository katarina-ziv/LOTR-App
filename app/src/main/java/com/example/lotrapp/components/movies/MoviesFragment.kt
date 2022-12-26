package com.example.lotrapp.components.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotrapp.R
import com.example.lotrapp.activities.MainActivity
import com.example.lotrapp.activities.MainViewModel
import com.example.lotrapp.adapters.BooksAdapter
import com.example.lotrapp.adapters.MoviesAdapter
import com.example.lotrapp.databinding.FragmentMoviesBinding
import com.example.lotrapp.services.utils.Resource

class MoviesFragment : Fragment() {


    private lateinit var binding: FragmentMoviesBinding
    lateinit var viewModel: MainViewModel
    lateinit var movieAdapter: MoviesAdapter

    val TAG = "MoviesFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()
        viewModel.movies.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { moviesResponse ->
                        movieAdapter.differ.submitList(moviesResponse.docs)

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
        movieAdapter = MoviesAdapter()
        binding.moviesRv.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(activity)
            Log.i("MoviesFragment", "rec view")
        }
    }
}

