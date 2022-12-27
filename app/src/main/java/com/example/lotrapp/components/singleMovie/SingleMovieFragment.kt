package com.example.lotrapp.components.singleMovie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.lotrapp.R
import com.example.lotrapp.activities.MainActivity
import com.example.lotrapp.activities.MainViewModel
import com.example.lotrapp.databinding.FragmentMoviesBinding
import com.example.lotrapp.databinding.FragmentSingleMovieBinding
import kotlin.math.roundToInt
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class SingleMovieFragment : Fragment() {

    private lateinit var binding: FragmentSingleMovieBinding
   lateinit var viewModel : MainViewModel
    val args : SingleMovieFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSingleMovieBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val movie = args.movie
        binding.apply {
            movieNameTv.text = movie.name
            //TODO ovo ne bi trebalo da ostane hardcoded, staviti u strings.xml
            scoreTv.text = movie.rottenTomatoesScore?.roundToInt().toString()+"%"
            budgetTv.text = "$"+movie.budgetInMillions.toString()+"mill"
            awardsTv.text = movie.academyAwardWins.toString()
            movieOverviewTv.text = movie.description
            movieImage.setImageResource(R.drawable.movie1)
            movieBackgroundImage.setImageResource(R.drawable.movie2)
        }

    }



}