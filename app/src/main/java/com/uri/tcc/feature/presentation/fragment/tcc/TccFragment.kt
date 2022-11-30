package com.uri.tcc.feature.presentation.fragment.tcc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uri.tcc.databinding.FragmentTccBinding

class TccFragment : Fragment() {

    private var _binding: FragmentTccBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, view: ViewGroup?, bundle: Bundle?): View {
        _binding = FragmentTccBinding.inflate(inflater, view, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}