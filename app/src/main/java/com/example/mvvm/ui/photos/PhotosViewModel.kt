package com.example.mvvm.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.PhotosRepository
import com.example.mvvm.domain.PhotosModel
import com.example.mvvm.network.NetworkProviderFactory
import kotlinx.coroutines.launch

class PhotosViewModel : ViewModel() {

    private val _text = MutableLiveData<ArrayList<PhotosModel>>()
    val text: LiveData<ArrayList<PhotosModel>> = _text

    init {
        val repository = PhotosRepository(NetworkProviderFactory.createMainApi()) // Fixme Temp solution, need to inject by constructor

        viewModelScope.launch {
            val photoList = repository.getPhotos()
            _text.postValue(photoList)
        }
    }
}