package com.example.myrecipes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecipes.categorias.Category
import com.example.myrecipes.R
import com.example.myrecipes.adapters.AdapterForCategories
import com.example.myrecipes.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(R.layout.fragment_categories), AdapterForCategories.RecyclerViewEvent {
    private lateinit var binding: FragmentCategoriesBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoriesBinding.bind(view)

        binding.categoriesRecycleView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = AdapterForCategories(Category.LIST, this@CategoriesFragment)
        }
    }

    override fun onItemClick(category: Category) {
        println("  asdf 0")

        val bundle = Bundle()
        bundle.putParcelable(Category.KEY_ARG, category)
        findNavController().navigate(R.id.listRecipesFragment, bundle)
    }
}