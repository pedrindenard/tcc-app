package com.uri.tcc.feature.presentation.fragment.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.uri.tcc.databinding.FragmentLibraryBinding
import com.uri.tcc.utils.LibraryMock
import org.koin.androidx.viewmodel.ext.android.viewModel

class LibraryFragment : Fragment() {

    private val viewModel by viewModel<LibraryViewModel>()
    private val mainAdapter by lazy { LibraryAdapter() }

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, view: ViewGroup?, bundle: Bundle?): View {
        _binding = FragmentLibraryBinding.inflate(inflater, view, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setObservers()
        setAdapter()
    }

    private fun setListeners() {

    }

    private fun setObservers() {
        mainAdapter.insertItems(LibraryMock.getLibraryMock())
    }

    private fun setAdapter() {
        binding.libraryRecyclerView.adapter = mainAdapter
        binding.libraryRecyclerView.layoutManager = GridLayoutManager(context, 2)
    }
}