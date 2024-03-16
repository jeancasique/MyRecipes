package com.example.myrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecipes.model.Ingredient
import com.example.myrecipes.R


class AdapterForIngredients(
    private val listIngredients: List<Ingredient>
): RecyclerView.Adapter<AdapterForIngredients.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val quantity: TextView = view.findViewById(R.id.quantity)
        val ingredient: TextView = view.findViewById(R.id.ingredient)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ingredients, parent, false)
        )
    }

    override fun getItemCount(): Int = listIngredients.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listIngredients[position]

        holder.quantity.text = item.quantity
        holder.ingredient.text = item.ingredient
    }
}

