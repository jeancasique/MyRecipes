package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.R
import com.example.myrecipes.model.Recipe
import com.squareup.picasso.Picasso

class AdapterForList(
    private val listRecipes: List<Recipe>,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<AdapterForList.ViewHolder>() {

    interface RecyclerViewEvent {
        fun onItemClickForList(recipe: Recipe)
    }

    inner class ItemViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {
        init {
            view.setOnClickListener(this)
        }

        //Getting reference to views within the row layout
        override fun onClick(v: View?) {
            val recipe = listRecipes[adapterPosition]
            listener.onItemClickForList(recipe)
        }

    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val image: ImageView = view.findViewById(R.id.image_in_list)
        val title: TextView = view.findViewById(R.id.title_in_list)

        init {
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val recipe = listRecipes[adapterPosition]
            listener.onItemClickForList(recipe)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_for_list, parent, false)
        )
    }

    override fun getItemCount(): Int = listRecipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listRecipes[position]

        Picasso.get()
            .load(item.image)
            .into(holder.image)

        holder.title.text = item.title
    }
}