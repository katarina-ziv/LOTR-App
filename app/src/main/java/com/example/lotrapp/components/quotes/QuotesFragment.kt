package com.example.lotrapp.components.quotes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lotrapp.R
import com.example.lotrapp.activities.MainActivity
import com.example.lotrapp.activities.MainViewModel
import com.example.lotrapp.adapters.QuotesAdapter
import com.example.lotrapp.databinding.FragmentQuotesBinding
import com.example.lotrapp.services.utils.Resource
import kotlinx.android.synthetic.main.item_quote.*

class QuotesFragment : Fragment() {


    private lateinit var binding: FragmentQuotesBinding
    lateinit var viewModel: MainViewModel
    private lateinit var quotesAdapter: QuotesAdapter

    val TAG = "QuotesFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()


        viewModel.quotes.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { quotesResponse ->
                        quotesAdapter.differ.submitList(quotesResponse.docs)

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
        quotesAdapter = QuotesAdapter(viewModel::saveQuote)
        binding.quotesRv.apply {
            adapter = quotesAdapter
            layoutManager = LinearLayoutManager(activity)

        }
    }

}