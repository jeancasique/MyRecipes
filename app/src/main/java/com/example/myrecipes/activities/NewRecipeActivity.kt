package com.example.myrecipes.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myrecipes.R
import com.example.myrecipes.data.DataBaseHelper
import com.example.myrecipes.databinding.NewRecipeBinding
import com.example.myrecipes.model.Recipe

class NewRecipeActivity : AppCompatActivity() {

    private lateinit var binding: NewRecipeBinding
    private var imageUri: Uri? = null

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            openGallery()
        } else {
            Toast.makeText(this, "Permiso denegado para acceder a la galería", Toast.LENGTH_SHORT).show()
        }
    }

    private val pickImageLauncher = registerForActivityResult(PickVisualMedia()) { uri ->
        if (uri != null) {
            imageUri = uri
            binding.imageView.setImageURI(uri)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el spinner de categorías
        val categorias = listOf("Postre", "Salado", "Bebida", "Otro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categorias)
        binding.spinnerCategoria.adapter = adapter

        // Función para abrir la galería
        private fun openGallery() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImageLauncher.launch(intent)
        }

        // Función para guardar la receta (fuera de onCreate)
        fun saveRecipe(name: String, description: String, category: String, favorite: Boolean, instructions: List<String>, rawCategories: List<String>) {
            // Crea una nueva instancia de la clase Recipe
            val recipe = Recipe(name, description, category, favorite, instructions, rawCategories)

            // Guarda la receta en la base de datos local SQLite
            val dbHelper = DataBaseHelper(this)
            val id = dbHelper.insertarReceta(recipe.imagen, recipe.descripcion, recipe.categoria, recipe.favorito, recipe.instrucciones, recipe.categoriasCrudas)

            if (id > 0) {
                // Muestra un mensaje de confirmación
                Toast.makeText(this, "Receta guardada correctamente", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                // Muestra un mensaje de error
                Toast.makeText(this, "Error al guardar la receta", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSave.setOnClickListener {
            // Validar los campos de entrada
            if (binding.editTextName.text.isEmpty()) {
                Toast.makeText(this, "El nombre de la receta es obligatorio", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (binding.editTextDescription.text.isEmpty()) {
                Toast.makeText(this, "La descripción de la receta es obligatoria", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Obtener los datos de la receta
            val name = binding.editTextName.text.toString()
            val description = binding.editTextDescription.text.toString()
            val category = binding.spinnerCategoria.selectedItem as String
            val favorite = binding.checkBoxFavorite.isChecked
            val instructions = binding.editTextInstructions.text.split("\n")
            val rawCategories = binding.editTextRawCategories.text.split(",")

            // Guardar la receta
            saveRecipe(name, description, category, favorite, instructions, rawCategories)
        }
    }
}
