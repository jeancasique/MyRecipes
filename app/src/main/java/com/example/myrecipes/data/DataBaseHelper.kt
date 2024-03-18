package com.example.myrecipes.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        // Crear la tabla "Recetas"
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS Recetas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "imagen TEXT," +
                    "descripcion TEXT," +
                    "categoria TEXT," +
                    "favorito INTEGER," +
                    "instrucciones TEXT," +
                    "categorias_crudas TEXT" +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Implementar la lógica para actualizar la base de datos en caso de cambios en la estructura
    }

    // Método para insertar una nueva receta
    fun insertarReceta(imagen: String?, descripcion: String?, categoria: String?, favorito: Boolean, instrucciones: List<String>, categoriasCrudas: List<String>): Long {
        val db = writableDatabase
        val values = ContentValues()
        values.put("imagen", imagen)
        values.put("descripcion", descripcion)
        values.put("categoria", categoria)
        values.put("favorito", favorito)
        values.put("instrucciones", instrucciones.joinToString(","))
        values.put("categorias_crudas", categoriasCrudas.joinToString(","))
        return db.insert("Recetas", null, values)
    }

    // Método para obtener todas las recetas
    fun obtenerTodasRecetas(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM Recetas", null)
    }

    // Método para obtener una receta por su ID
    fun obtenerRecetaPorId(id: Int): Cursor {
        val db = readableDatabase
        val args = arrayOf(id.toString())
        return db.rawQuery("SELECT * FROM Recetas WHERE id=?", args)
    }

    // Método para actualizar una receta
    fun actualizarReceta(id: Int, imagen: String?, descripcion: String?, categoria: String?, favorito: Boolean, instrucciones: List<String>, categoriasCrudas: List<String>): Int {
        val db = writableDatabase
        val values = ContentValues()
        values.put("imagen", imagen)
        values.put("descripcion", descripcion)
        values.put("categoria", categoria)
        values.put("favorito", favorito)
        values.put("instrucciones", instrucciones.joinToString(","))
        values.put("categorias_crudas", categoriasCrudas.joinToString(","))
        val args = arrayOf(id.toString())
        return db.update("Recetas", values, "id=?", args)
    }

    // Método para eliminar una receta
    fun eliminarReceta(id: Int): Int {
        val db = writableDatabase
        val args = arrayOf(id.toString())
        return db.delete("Recetas", "id=?", args)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "MyRecipes.db"
    }
}
