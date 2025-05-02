package com.example.mynews.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynews.APIKEY
import com.example.mynews.data.local.NewsRepository
import com.example.mynews.data.local.SavedNews
import com.example.mynews.data.model.Article
import com.example.mynews.data.model.Main
import com.example.mynews.data.remote.NewsService
import com.example.mynews.presentation.state.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val apiService: NewsService,
    private val repository: NewsRepository,
) : ViewModel() {

    private val _inputValue: MutableState<String> = mutableStateOf("")
    var inputValue: State<String> = _inputValue

    private val _savedNews = MutableStateFlow<List<SavedNews>>(emptyList())
    val savedNews: StateFlow<List<SavedNews>> get() = _savedNews

    private val _state = MutableStateFlow(NewsState())
    val state: StateFlow<NewsState> = _state.asStateFlow()

    private val _newsList = mutableStateOf<List<Article>>(emptyList())
    val newsList: State<List<Article>> = _newsList

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    private val _category = mutableStateOf<String?>("All")
    val category: State<String?> = _category

    val categorySafe
        get() = if (category.value.isNullOrEmpty()) {
            null
        } else if (category.value == "All") {
            "general"
        } else {
            category.value
        }

    init {
        println("init started")
        viewModelScope.launch {
            _query
                .debounce(1000)
                .distinctUntilChanged()
                .collect { newQuery ->
                    fetchNews(newQuery)
                    _category.value="All"
                }
        }
        fetchNews("")

        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllNews().collect { newsList ->
                _savedNews.value = newsList
            }
        }
    }


    fun handleApiCall(call: Call<Main>) {
        call.enqueue(
            object : Callback<Main> {
                override fun onResponse(
                    call: Call<Main?>,
                    response: Response<Main?>
                ) {
                    _newsList.value = response.body()?.articles ?: emptyList()
                    _state.value = _state.value.copy(
                        isLoading = false,
                        onSuccess = true
                    )
                    Log.d("RETROFIT", "${response.body()}")
                }

                override fun onFailure(
                    call: Call<Main?>,
                    t: Throwable
                ) {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        onError = true
                    )
                    Log.e("RETROFIT", "${t.message}")
                }
            }
        )
    }

    fun updateCategory(newCategory: String?) {
        _category.value = newCategory
        fetchNews(query.value)
    }

    private fun fetchNews(query: String) {
        val call = if (query.isEmpty()) {
            apiService.getTopHeadlinesNews(
                country = "us",
                language = "en",
                category = categorySafe,
                apiKey = APIKEY
            )
        } else {
            apiService.getEverythingNews(query, "en", APIKEY)
        }
        handleApiCall(call)
    }

    fun updateQuery() {
        _query.value = inputValue.value
    }

    fun updateInput(newInput: String){
        _inputValue.value = newInput
    }

    fun retry(){
        _state.value = _state.value.copy(
            onError = false,
            isLoading = true
        )
        fetchNews(_query.value)
    }
    suspend fun addNews(news: SavedNews) {
        repository.addNews(news)
        Log.d("ROOM", "Added: $news")
    }

    suspend fun deleteNews(news: SavedNews) {
        repository.deleteNews(news)
        Log.d("ROOM", "Deleted: $news")
    }
}