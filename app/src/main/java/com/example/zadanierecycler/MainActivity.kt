package com.example.zadanierecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.zadanierecycler.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        
        binding.btn1.setOnClickListener{
            val elem = ArrayList<String>()
            val chosenImg = Constants.images.random()
            elem.add("$chosenImg.png")
            elem.add(chosenImg)
            Globals.imageList.add(elem)
            updateRecycler()
        }

        binding.btn2.setOnClickListener{

        }

        binding.btn3.setOnClickListener{

        }

        binding.btn4.setOnClickListener{

        }

        binding.btn5.setOnClickListener{

        }

        binding.btn6.setOnClickListener{

        }

        binding.ColumnInput.addTextChangedListener{
            Toast.makeText(this, "Columns: ${binding.ColumnInput.text}", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateRecycler(){
        binding.recycler.adapter = Adapter(Globals.imageList, this)
    }
}