package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.R
import com.example.myrecipes.model.Recipe
import com.squareup.picasso.Picasso


class AdapterForCards(
    private val listRecipes: List<Recipe>,
    private val listener: RecyclerViewEvent
) : RecyclerView.Adapter<AdapterForCards.ViewHolder>() {

    interface RecyclerViewEvent {
        fun onItemClickForCards(recipe: Recipe)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val image: ImageView = view.findViewById(R.id.image_in_card)
        val title: TextView = view.findViewById(R.id.title_in_card)
        val ingredientsRV: RecyclerView = view.findViewById(R.id.ingredients_recycle_view)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val recipe = listRecipes[adapterPosition]
            listener.onItemClickForCards(recipe)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_card, parent, false)
        )
    }

    override fun getItemCount(): Int = listRecipes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = listRecipes[position]

        Picasso.get()
            .load(item.image)
            .into(holder.image)

        holder.title.text = item.title


        holder.ingredientsRV.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = AdapterForIngredients(item.ingredients)
        }

    }
}










