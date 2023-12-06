package com.example.homework_sandbox_week01

import android.app.Activity
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths

@RequiresApi(Build.VERSION_CODES.O)
fun ImageView.getImageFromURL(activity : AppCompatActivity, adress : String, imgView : ImageView){
    //"https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Spis_Castle_116.jpg/2560px-Spis_Castle_116.jpg"
//    var uri = URI.create(adress);
//    var url = uri.toURL();

    Glide.with(activity).asDrawable().load(adress).into(imgView)
}