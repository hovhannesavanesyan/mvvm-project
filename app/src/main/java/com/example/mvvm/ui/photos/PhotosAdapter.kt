package com.example.mvvm.ui.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.mvvm.R
import com.example.mvvm.domain.PhotosModel

class PhotosAdapter(private val photoList: ArrayList<PhotosModel>) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return PhotoViewHolder(inflater)
    }

    override fun getItemCount() = photoList.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    class PhotoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image_view)
        val authorNameTextView: TextView = view.findViewById(R.id.author_text_view)

        fun bind(item: PhotosModel) {
            Glide.with(view.context)
                .load(item.download_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)

            authorNameTextView.text = item.author
        }
    }
}