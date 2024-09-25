package com.example.testimageviev

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityImageView : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var image: ImageView
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_image_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.button)
        image = findViewById(R.id.imageIV)
        image.setImageResource(R.drawable.image_1)
        button.setOnClickListener {
            count++
            when(count){
                2->image.setImageResource(R.drawable.image_2)
                3->image.setImageResource(R.drawable.image_3)
                4->image.setImageResource(R.drawable.image_4)
                5->image.setImageResource(R.drawable.image_5)
                6-> {
                    count = 1
                    val intent1 = Intent()
                    intent1.putExtra("text", "Просмотр окончен")
                    setResult(RESULT_OK, intent1)
                    finish()
                }
            }
        }

    }
}

