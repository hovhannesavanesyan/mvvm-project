package com.example.mvvm.data

import com.example.mvvm.domain.PhotosModel
import com.example.mvvm.network.MainApiService

class PhotosRepository(private val apiService: MainApiService) {

    suspend fun getPhotos(): ArrayList<PhotosModel> {
        return apiService.getPhotoList()
    }
}