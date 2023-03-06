package com.example.zadanierecycler

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val dataSet: ArrayList<ArrayList<String>>, private val mainActivity: MainActivity) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View, mainActivity: MainActivity) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            imageView = view.findViewById(R.id.img)
            textView = view.findViewById(R.id.text)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.single_element, viewGroup, false)

        return ViewHolder(view, mainActivity)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Log.d("dbg", position.toString())
        Log.d("dbg", dataSet[position][0])
        viewHolder.imageView.setImageDrawable(Drawable.createFromPath(dataSet[position][0]))
        viewHolder.textView.text = dataSet[position][1]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}