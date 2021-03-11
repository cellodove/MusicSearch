package com.peter.musicsearch.main

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

    val artistDataLiveData : LiveData<ArtistData>
        get() = _artistResponseLiveData


    fun searchArtist(artist : String){
        viewModelScope.launch {
            _artistResponseLiveData.value = appRepository.searchArtist(artist)
        }
    }

    fun toggleItemOpen(position: Int) {
        artistDataLiveData.value?.response?.hitsList?.get(position)?.result?.toggle()
    }
}