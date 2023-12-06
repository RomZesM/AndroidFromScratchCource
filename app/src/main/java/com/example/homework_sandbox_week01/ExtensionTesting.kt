package com.example.homework_sandbox_week01

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.homework_sandbox_week01.utils.getImageFromURL

class ExtensionTesting : AppCompatActivity() {

    var adress = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/Spis_Castle_116.jpg/2560px-Spis_Castle_116.jpg"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extention_testing)
        initGetImgButton();
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initGetImgButton() {
        val button : Button = findViewById(R.id.get_image_Button)

        button.setOnClickListener({
            val image : ImageView = findViewById(R.id.image_view)
            //get image from ImageView extension 
            image.getImageFromURL(this, adress);
        })

    }
}