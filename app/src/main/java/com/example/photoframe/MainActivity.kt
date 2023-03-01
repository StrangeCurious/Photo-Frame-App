package com.example.photoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    val names = arrayOf("Virat Kohli","Elon Musk","Steve Jobs","Jeff Bezos")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val nextImage = findViewById<ImageButton>(R.id.imgNextBtn)
        val prevImage = findViewById<ImageButton>(R.id.imgPrevBtn)
        val text = findViewById<TextView>(R.id.textView)

        prevImage.setOnClickListener {
            val currentImageIdString = "imageView$currentImage"
            val currentImageIdInt = this.resources.getIdentifier(currentImageIdString,"id",packageName)
            image = findViewById(currentImageIdInt)
            image.alpha = 0f

            currentImage = (4+ currentImage - 1) % 4
            val imageToShowString = "imageView$currentImage"
            val imageToShowIdInt = this.resources.getIdentifier(imageToShowString,"id",packageName)
            image = findViewById(imageToShowIdInt)
            Toast.makeText(this,"$imageToShowIdInt", Toast.LENGTH_SHORT).show()
            image.alpha = 1f
            text.text  = names[currentImage]

        }

        nextImage.setOnClickListener {
            val currentImageIdString = "imageView$currentImage"
            val currentImageIdInt = this.resources.getIdentifier(currentImageIdString,"id",packageName)
            image = findViewById(currentImageIdInt)
            image.alpha = 0f

            currentImage = (4+ currentImage + 1) % 4
            val imageToShowString = "imageView$currentImage"
            val imageToShowIdInt = this.resources.getIdentifier(imageToShowString,"id",packageName)
            image = findViewById(imageToShowIdInt)
            image.alpha = 1f
            text.text  = names[currentImage]
        }
    }
}