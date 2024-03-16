package com.example.myrecipes.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myrecipes.R
import com.example.myrecipes.model.Recipe
import com.example.myrecipes.databinding.FragmentRecipeDetailsBinding
import com.google.android.material.sidesheet.SideSheetDialog


class RecipeDetailsFragment : Fragment(R.layout.fragment_recipe_details) {
    private lateinit var binding: FragmentRecipeDetailsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailsBinding.bind(view)

        val parcelableRecipe = arguments?.getParcelable<Recipe>(Recipe.KEY_ARG)

        val sideSheetDialog = SideSheetDialog(requireContext())
        sideSheetDialog.setContentView(R.layout.side_sheet)

        binding.testButton.setOnClickListener {
            sideSheetDialog.show()
        }

    }
}