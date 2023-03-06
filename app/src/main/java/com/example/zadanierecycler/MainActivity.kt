package com.example.zadanierecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zadanierecycler.databinding.ActivityMainBinding
import java.lang.Integer.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resetOccurrences()

        binding.recycler.layoutManager = GridLayoutManager(binding.recycler.context, 1, RecyclerView.VERTICAL, false)


        binding.btn1.setOnClickListener{
            save()
            val chosenImg = Constants.images.random()
            Globals.imageList.add(chosenImg)
            Globals.occurrences[chosenImg] = if(Globals.occurrences[chosenImg] != null) Globals.occurrences[chosenImg]!! + 1 else 0
            Globals.occurrencesList.add(Globals.occurrences[chosenImg]!!)
            updateRecycler()
        }

        binding.btn2.setOnClickListener{
            save()
            Globals.imageList = ArrayList()
            Globals.occurrencesList = ArrayList()
            updateRecycler()
            resetOccurrences()
        }

        binding.btn3.setOnClickListener{
            if(Globals.imageList.size != 0) {
                save()
                removeImageByIndex(0)
            }
        }

        binding.btn4.setOnClickListener{
            if(Globals.imageList.size != 0) {
                save()
                removeImageByIndex(Globals.imageList.size - 1)
            }
        }

        binding.btn5.setOnClickListener{
            if(Globals.imageList.size != 0) {
                save()
                removeImageByIndex(Random.nextInt(0, Globals.imageList.size))
            }
        }

        binding.btn6.setOnClickListener{
            Globals.imageList = Globals.previousImageList
            refreshOccurrences()
            updateRecycler()
        }

        binding.ColumnInput.addTextChangedListener{
            var st = binding.ColumnInput.text.toString()
            if(st==""){
                st = Constants.minTableCols.toString()
            }
            val si = st.toInt()
            if(si > Constants.maxTableCols){
                binding.ColumnInput.setText(Constants.maxTableCols.toString())
            }
            val cols = kotlin.math.max(Constants.minTableCols, min(Constants.maxTableCols, si))
            binding.recycler.layoutManager = GridLayoutManager(binding.recycler.context, cols, RecyclerView.VERTICAL, false)
        }
    }

    private fun updateRecycler(){
        binding.recycler.adapter = Adapter(Globals.imageList, this)
    }

    private fun resetOccurrences(){
        for(elem: String in Constants.images){
            Globals.occurrences[elem] = 0
        }
    }

    private fun removeImageByIndex(index: Int){
        if(index >= Globals.imageList.size || index < 0){
            return
        }
        Globals.imageList.removeAt(index)
        refreshOccurrences()
        updateRecycler()
    }

    private fun refreshOccurrences(){
        resetOccurrences()
        Globals.occurrencesList = ArrayList()
        for(elem in Globals.imageList){
            Globals.occurrences[elem] = if(Globals.occurrences[elem] != null) Globals.occurrences[elem]!! + 1 else 0
            Globals.occurrencesList.add(Globals.occurrences[elem]!!)
        }
    }

    private fun save(){
        Globals.previousImageList = ArrayList()
        Globals.previousImageList.addAll(Globals.imageList)
    }
}