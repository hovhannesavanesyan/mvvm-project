package com.example.mvvm.data

import com.example.mvvm.domain.PhotosModel

fun ArrayList<PhotoDto>.mapToUiModel(): ArrayList<PhotosModel> {
    val photoList = arrayListOf<PhotosModel>()

    forEach {
        photoList.add(PhotosModel(it.id, it.author, it.url, it.download_url))
    }

    return photoList
}