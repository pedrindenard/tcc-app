package com.uri.tcc.feature.presentation.fragment.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uri.tcc.databinding.ItemLibraryBinding
import com.uri.tcc.utils.LibraryMock

class LibraryAdapter : RecyclerView.Adapter<LibraryAdapter.ViewHolder>() {

    private val items = arrayListOf<LibraryMock.Library>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLibraryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val binding: ItemLibraryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(library: LibraryMock.Library) {
            binding.libraryTitle.text = library.title
            binding.libraryAuthor.text = library.author
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun insertItems(newList: List<LibraryMock.Library>) {
        items.clear()
        items.addAll(newList)
        notifyDataSetChanged()
    }
}