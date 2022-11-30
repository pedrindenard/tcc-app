package com.uri.tcc.feature.presentation.activity.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.uri.tcc.core.Resource
import com.uri.tcc.databinding.ActivityLoginBinding
import com.uri.tcc.feature.data.local.SharedPreferencesImpl
import com.uri.tcc.feature.domain.body.auth.LoginBody
import com.uri.tcc.feature.domain.model.auth.LoginResponse
import com.uri.tcc.feature.presentation.activity.home.HomeActivity
import com.uri.tcc.feature.presentation.activity.register.RegisterActivity
import com.uri.tcc.utils.Converters.fromJsonTo
import com.uri.tcc.utils.SnackBar.createSnackBarInActivity
import com.uri.tcc.utils.StringFormat.toEditable
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModel<LoginViewModel>()

    private lateinit var binding: ActivityLoginBinding

    private val activityResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val email = result.data?.getSerializableExtra("email") as String
            val password = result.data?.getSerializableExtra("password") as String

            binding.loginPasswordEditText.text = password.toEditable()
            binding.loginEmailEditText.text = email.toEditable()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setInitialValue()
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        binding.loginButtonSignIn.setOnClickListener {
            val email = binding.loginEmailEditText.text.toString()
            val password = binding.loginPasswordEditText.text.toString()
            viewModel.doLogin(LoginBody(email, password))
        }

        binding.loginButtonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            activityResult.launch(intent)
        }

        binding.loginPasswordEditText.apply { doAfterTextChanged { error = null } }
        binding.loginEmailEditText.apply { doAfterTextChanged { error = null } }
    }

    private fun setObservers() {
        lifecycleScope.launchWhenResumed {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiFormEvent.collectLatest { result ->
                    when (result) {
                        is LoginViewModel.UiLoginEvent.InvalidEmail -> {
                            binding.loginEmailEditText.error = result.message.asString(binding.root.context)
                        }
                        is LoginViewModel.UiLoginEvent.InvalidPassword -> {
                            binding.loginPasswordEditText.error = result.message.asString(binding.root.context)
                        }
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
                            val intent = Intent(binding.root.context, HomeActivity::class.java)

                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                                Intent.FLAG_ACTIVITY_NEW_TASK or
                                Intent.FLAG_ACTIVITY_CLEAR_TASK
                            )

                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    private fun setInitialValue() {
        SharedPreferencesImpl(this).apply {
            val form = get(SharedPreferencesImpl.Setting.USER_LOGIN).fromJsonTo<LoginBody>()
            val result = get(SharedPreferencesImpl.Setting.USER_TOKEN).fromJsonTo<LoginResponse>()

            when {
                result != null -> {
                    val intent = Intent(binding.root.context, HomeActivity::class.java)

                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                        Intent.FLAG_ACTIVITY_NEW_TASK or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                    )

                    startActivity(intent)
                }
                form != null -> {
                    binding.loginPasswordEditText.text = form.password.toEditable()
                    binding.loginEmailEditText.text = form.email.toEditable()
                }
            }
        }
    }
}