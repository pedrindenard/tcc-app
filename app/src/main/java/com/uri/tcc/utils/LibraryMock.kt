package com.uri.tcc.utils

object LibraryMock {

    fun getLibraryMock(): List<Library> {
        val items = arrayListOf<Library>()
        (1..12).forEachIndexed { index, _ ->
            items.add(
                Library(
                    "Título $index",
                    "Autor $index",
                    "Imagem $index",
                )
            )
        }
        return items
    }

    data class Library(
        val title: String,
        val author: String,
        val image: String
    )
}