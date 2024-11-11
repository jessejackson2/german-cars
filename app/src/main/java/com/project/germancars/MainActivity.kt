package com.project.germancars

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //this function loads the layout and sets the click listeners for the car images and the clear button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //initialize the views
        val statusText: TextView = findViewById(R.id.status_text)
        val clearButton: Button = findViewById(R.id.clear_button)
        val bmwImage: ImageView = findViewById(R.id.bmw_image)
        val audiImage: ImageView = findViewById(R.id.audi_image)
        val porscheImage: ImageView = findViewById(R.id.porsche_image)
        val carsGroupImage: LinearLayout = findViewById(R.id.cars_image_layout)

        //set the click listeners for the car images and the clear button
        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.bmw_image -> statusText.text = "You clicked on the BMW!"
                R.id.audi_image -> statusText.text = "You clicked on the Audi!"
                R.id.porsche_image -> statusText.text = "You clicked on the Porsche!"
                R.id.cars_image_layout -> statusText.text = "You clicked on the cars group!"
            }
            clearButton.visibility = View.VISIBLE
        }

        //assign the click listeners to the views
        bmwImage.setOnClickListener(clickListener)
        audiImage.setOnClickListener(clickListener)
        porscheImage.setOnClickListener(clickListener)
        carsGroupImage.setOnClickListener(clickListener)

        clearButton.setOnClickListener {
            statusText.text = "Please touch on one of the car icons"
            clearButton.visibility = View.GONE
        }
    }
}
