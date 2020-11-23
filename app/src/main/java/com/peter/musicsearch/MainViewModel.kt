package com.peter.musicsearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peter.musicsearch.repository.AppRepository
import com.peter.musicsearch.repository.data.ArtistData
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val appRepository = AppRepository()

    //데이터 변화하는것을 알아본다.
    private val _artistResponseLiveData = MutableLiveData<ArtistData>()

    val artistResponseLiveData : LiveData<ArtistData>
        get() = _artistResponseLiveData


    fun searchArtist(artist : String){
        viewModelScope.launch {

        }

    }
}