package com.example.zadanierecycler

class Globals {
    companion object{
        var imageList: ArrayList<String> = ArrayList()
        var previousImageList = ArrayList<String>()
        var occurrences: MutableMap<String, Int> = mutableMapOf()
        var occurrencesList = ArrayList<Int>()
    }
}