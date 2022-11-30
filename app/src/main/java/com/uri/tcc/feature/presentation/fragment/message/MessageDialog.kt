package com.uri.tcc.feature.presentation.fragment.message

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.uri.tcc.databinding.DialogEditMessageBinding
import com.uri.tcc.utils.CountDownTimer
import com.uri.tcc.utils.StringFormat.toEditable

class MessageDialog : BottomSheetDialogFragment() {

    private lateinit var clickListener: ClickListener

    private var _binding: DialogEditMessageBinding? = null
    private val binding get() = _binding!!

    @Suppress(names = ["DEPRECATION"])
    override fun onStart() {
        super.onStart()
        if (dialog != null && dialog!!.window != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                dialog!!.window!!.setDecorFitsSystemWindows(false)
            } else {
                dialog!!.window!!.setSoftInputMode(
                    WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
                )
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, view: ViewGroup?, bundle: Bundle?): View {
        _binding = DialogEditMessageBinding.inflate(inflater, view, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickListener.setFieldMessage()
        setDecorViewListener()
        setListeners()
    }

    private fun setListeners() {
        binding.messageSend.setOnClickListener {
            val message = binding.messageInput.text.toString()
            clickListener.onClick(message)
            dismiss()
        }
    }

    private fun setDecorViewListener() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            ViewCompat.setOnApplyWindowInsetsListener(
                requireDialog().window!!.decorView
            ) { _: View, insets: WindowInsetsCompat ->
                val imeHeight = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
                binding.root.setPadding(0, 0, 0, imeHeight)
                insets
            }
        }
    }

    fun insertInputFieldMessage(message: String) {
        CountDownTimer.getDelayMillis(100) {
            binding.messageInput.text = message.toEditable()
        }
    }

    fun setOnClickListener(mClickListener: ClickListener) {
        clickListener = mClickListener
    }

    interface ClickListener {
        fun onClick(text: String)
        fun setFieldMessage()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}