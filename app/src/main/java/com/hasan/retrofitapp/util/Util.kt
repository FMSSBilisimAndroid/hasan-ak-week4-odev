package com.hasan.retrofitapp.util


import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy


import com.bumptech.glide.request.RequestOptions
import com.hasan.retrofitapp.R


fun ImageView.downloadFromUrl(url: String?){

    val options = RequestOptions()
        .centerCrop()
        .placeholder(R.drawable.progress_animation)
        .error(R.drawable.ic_launcher_background)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)
        .dontAnimate()
        .dontTransform();



    GlideApp.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .centerCrop()
        .into(this)



}

fun placeholderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f

        start()

    }
}



@BindingAdapter("android:downloadUrl")
fun downloadImage(view: ImageView, url:String?) {
    view.downloadFromUrl(url)
}