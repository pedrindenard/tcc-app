package com.uri.tcc.feature.presentation.activity.register

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.ListPopupWindow
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.uri.tcc.R
import com.uri.tcc.core.Resource
import com.uri.tcc.databinding.ActivityRegisterBinding
import com.uri.tcc.feature.domain.body.auth.RegisterBody
import com.uri.tcc.feature.domain.model.library.AllClassResponse
import com.uri.tcc.utils.SnackBar.createSnackBarInActivity
import com.uri.tcc.utils.StringFormat.toEditable
import com.uri.tcc.utils.ViewExtension.setBackgroundColor
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterActivity : AppCompatActivity() {

    private val viewModel by viewModel<RegisterViewModel>()
    private val items by lazy { arrayListOf<AllClassResponse>() }

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var popupWindow: ListPopupWindow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.loginButtonSignIn.setOnClickListener {
            val name = binding.registerNameEditText.text.toString()
            val email = binding.registerEmailEditText.text.toString()
            val cpf = binding.registerDocumentEditText.text.toString()
            val password = binding.registerPasswordEditText.text.toString()
            viewModel.doRegister(RegisterBody(email, password, name, cpf, getClassId()))
        }

        binding.registerCourseEditText.setOnClickListener {
            viewModel.getAllClass()
        }

        binding.loginButtonRegister.setOnClickListener {
            finish()
        }

        binding.registerNameEditText.apply { doAfterTextChanged { error = null } }
        binding.registerEmailEditText.apply { doAfterTextChanged { error = null } }
        binding.registerDocumentEditText.apply { doAfterTextChanged { error = null } }
        binding.registerPasswordEditText.apply { doAfterTextChanged { error = null } }
    }

    private fun setObservers() {
        lifecycleScope.launchWhenResumed {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiFormEvent.collectLatest { result ->
                    when (result) {
                        is RegisterViewModel.UiRegisterEvent.InvalidCPF ->
                            binding.registerDocumentEditText.error = result.message.asString(binding.root.context)
                        is RegisterViewModel.UiRegisterEvent.InvalidClass ->
                            binding.registerCourseEditText.error = result.message.asString(binding.root.context)
                        is RegisterViewModel.UiRegisterEvent.InvalidEmail ->
                            binding.registerEmailEditText.error = result.message.asString(binding.root.context)
                        is RegisterViewModel.UiRegisterEvent.InvalidName ->
                            binding.registerNameEditText.error = result.message.asString(binding.root.context)
                        is RegisterViewModel.UiRegisterEvent.InvalidPassword ->
                            binding.registerPasswordEditText.error = result.message.asString(binding.root.context)
                    }
                }
            }
        }

        lifecycleScope.launchWhenResumed {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiLoginEvent.collectLatest { result ->
                    when (result) {
                        is Resource.Error -> {
                            createSnackBarInActivity(result.message)
                        }
                        is Resource.Failure -> {
                            createSnackBarInActivity(result.throwable.message.toString())
                        }
                        is Resource.Loading -> {
                            binding.loginLoading.isVisible = result.isLoading
                        }
                        is Resource.Success -> {
                            val intent = Intent()

                            intent.putExtra("email", binding.registerEmailEditText.text.toString())
                            intent.putExtra("password", binding.registerPasswordEditText.text.toString())

                            setResult(Activity.RESULT_OK, intent)
                            finish()
                        }
                    }
                }
            }
        }

        lifecycleScope.launchWhenResumed {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiClassEvent.collectLatest { result ->
                    when (result) {
                        is Resource.Error -> {
                            createSnackBarInActivity(result.message)
                        }
                        is Resource.Failure -> {
                            createSnackBarInActivity(result.throwable.message.toString())
                        }
                        is Resource.Loading -> {
                            binding.loginLoading.isVisible = result.isLoading
                        }
                        is Resource.Success -> {
                            val item = arrayListOf<String>()

                            items.clear()
                            items.addAll(result.data)
                            items.forEach { item.add(it.name) }

                            setCountryDrawer(item)

                            popupWindow.show()
                        }
                    }
                }
            }
        }
    }

    private fun setCountryDrawer(array: List<String>) {
        popupWindow = ListPopupWindow(this, null, android.R.attr.dropDownListViewStyle)

        popupWindow.setAdapter(ArrayAdapter(this, R.layout.item_menu, array))
        popupWindow.setBackgroundColor(R.drawable.background_menu, this)

        popupWindow.anchorView = binding.registerCourseInputLayout

        popupWindow.setOnItemClickListener { _, _, position, _ ->
            binding.registerCourseEditText.text = array[position].toEditable()
            popupWindow.dismiss()
        }
    }

    private fun getClassId(): String {
        val classText = binding.registerCourseEditText.text.toString()
        val classId = items.firstOrNull { classText == it.name }
        return classId?.id ?: ""
    }
}