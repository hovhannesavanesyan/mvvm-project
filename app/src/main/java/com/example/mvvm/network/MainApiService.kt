package com.example.mvvm.network

import com.example.mvvm.domain.PhotosModel
import retrofit2.http.GET

interface MainApiService {

    @GET("list?page=1&limit=100")
    suspend fun getPhotoList(): ArrayList<PhotosModel>
}