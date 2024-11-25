package com.example.kuzminaa_01_02

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    lateinit var image: ImageView
    lateinit var spin: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        val textView: TextView = findViewById(R.id.edit)
        val i=intent.getIntExtra("index", 0)
        if(i==1)
        {
            image=findViewById(R.id.im)
            val perimeter = intent.getDoubleExtra("PERIMETER", 0.0)
            textView.text = "Периметр треугольника: $perimeter"
            image.setImageResource(R.drawable.v3)
            spin=findViewById(R.id.spinner)
            spin.text="Треугольник"
        }
        if(i==2)
        {
            image=findViewById(R.id.im)
            val perimeter = intent.getDoubleExtra("PERIMETER", 0.0)
            textView.text = "Периметр круга: $perimeter"
            image.setImageResource(R.drawable.v1)
            spin=findViewById(R.id.spinner)
            spin.text="Круг"
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}