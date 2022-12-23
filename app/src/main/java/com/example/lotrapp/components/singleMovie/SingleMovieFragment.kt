package com.example.lotrapp.components.singleMovie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lotrapp.R

class SingleMovieFragment : Fragment() {

    companion object {
        fun newInstance() = SingleMovieFragment()
    }

    private lateinit var viewModel: SingleMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_single_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SingleMovieViewModel::class.java)
        // TODO: Use the ViewModel
    }

}