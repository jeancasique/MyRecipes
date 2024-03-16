package com.example.myrecipes.categorias

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class Category(
    val title: String,
    val image: String
): Parcelable {
    VEGETABLES(
        "Vegetables",
        "https://images.unsplash.com/photo-1540420773420-3366772f4999?q=80&w=1968&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    DESSERT(
        "Desserts",
        "https://images.unsplash.com/photo-1571115177098-24ec42ed204d?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    BAKERY(
        "Bakery",
        "https://images.unsplash.com/photo-1587248720327-8eb72564be1e?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    MEAT(
        "Meat",
        "https://images.unsplash.com/photo-1606728035253-49e8a23146de?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    DRINKS(
        "Drinks",
        "https://images.unsplash.com/photo-1551024709-8f23befc6f87?q=80&w=2157&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    MAIN_COURSE(
        "Main course",
        "https://images.unsplash.com/photo-1547928576-b822bc410bdf?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    SOUP(
        "Soup",
        "https://images.unsplash.com/photo-1605034997426-399051e3f7ae?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    ),
    FAVORITE(
        "Favorite",
        "https://plus.unsplash.com/premium_photo-1673591578805-963e9a71f18d?q=80&w=1931&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    );

    companion object {
        val LIST = buildList {
            for (value in values())
                add(value)
        }

        val KEY_ARG = "category"
    }
}











