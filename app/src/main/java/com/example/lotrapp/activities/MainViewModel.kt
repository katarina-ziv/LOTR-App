package com.example.lotrapp.activities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lotrapp.models.BaseResponse
import com.example.lotrapp.models.Book
import com.example.lotrapp.models.Movie
import com.example.lotrapp.serviceLayer.Repository
import com.example.lotrapp.services.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val repository: Repository) : ViewModel() {

    val books : MutableLiveData<Resource<BaseResponse<Book>>> = MutableLiveData()
    val movies : MutableLiveData<Resource<BaseResponse<Movie>>> = MutableLiveData()
    var booksPage = 1


    //BOOKS

    fun getBooks(page: Int) = viewModelScope.launch {
        books.postValue(Resource.Loading())
        val response = repository.getBooks(page)
        books.postValue(handleBooksResponse(response))
    }

    private fun handleBooksResponse(response: Response<BaseResponse<Book>>) : Resource<BaseResponse<Book>>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
    //MOVIES
    fun getMovies() = viewModelScope.launch {
        movies.postValue(Resource.Loading())
        val response = repository.getMovies()
        movies.postValue(handleMoviesResponse(response))
    }

    private fun handleMoviesResponse(response: Response<BaseResponse<Movie>>) : Resource<BaseResponse<Movie>>{
        if(response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

  //INIT
    init {
        getBooks(booksPage)
        getMovies()
        Log.i("MainViewModel","getBooks pozvano")
    }
}