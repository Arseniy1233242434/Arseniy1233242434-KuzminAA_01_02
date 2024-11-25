package com.example.kuzminaa_01_02

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.emptyLongSet
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kuzminaa_01_02.R.*

class MainActivity3 : AppCompatActivity() {
    lateinit var spinner:Spinner
    lateinit var image:ImageView
    lateinit var editText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        enableEdgeToEdge()
        setContentView(layout.activity_main2)
        spinner=findViewById(id.spinner)
        image=findViewById(id.im)
        ArrayAdapter.createFromResource(
            this,
            R.array.Figure,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if(spinner.selectedItem=="Круг")
                        image.setImageResource(R.drawable.v1)
                    else
                        image.setImageResource(R.drawable.v3)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}

    fun ff(view: View)
    {
        if(spinner.selectedItem=="Треугольник")
        {
            editText=findViewById(id.edit)
            val input = editText.text.toString()
            val values = input.split(" ")
            if (values.size == 2) {
                val a = values[0].toDoubleOrNull()
                val b = values[1].toDoubleOrNull()

                if (a != null && b != null)
                {
                    val perimeter = 2*a+b
                    val intent = Intent(this, MainActivity4::class.java)
                    intent.putExtra("PERIMETER", perimeter)
                    intent.putExtra("index", 1)
                    startActivity(intent)
                }
                else
                {
                    AlertDialog.Builder(this)
                        .setTitle("Ошибка")
                        .setMessage("Введите корректные значения для a и b.").show()
                }
            }
            else
            {
                AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Введите два значения через пробел.").show()
            }

        }
        else
        {
            editText=findViewById(id.edit)
            val input = editText.text.toString()
            val a=input.toDoubleOrNull()
            if (a!= null )
            {

                val perimeter = a?.div(2*3.14)
                val intent = Intent(this, MainActivity4::class.java)
                intent.putExtra("PERIMETER", perimeter)
                intent.putExtra("index", 2)
                startActivity(intent)
            }
            else
            {
                AlertDialog.Builder(this)
                    .setTitle("Ошибка")
                    .setMessage("Введите корректное значение").show()
            }
        }

        }

    }
