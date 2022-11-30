package com.uri.tcc.feature.presentation.fragment.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uri.tcc.core.Resource
import com.uri.tcc.databinding.FragmentMessageBinding
import com.uri.tcc.feature.domain.body.message.MessageEditBody
import com.uri.tcc.utils.CountDownTimer
import com.uri.tcc.utils.SnackBar.createSnackBarInFragment
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class MessageFragment : Fragment() {

    private val viewModel by viewModel<MessageViewModel>()
    private val mainAdapter by lazy { MessageAdapter() }
    private val mainDialog by lazy { MessageDialog() }

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMessages()
    }

    override fun onCreateView(inflater: LayoutInflater, view: ViewGroup?, bundle: Bundle?): View {
        _binding = FragmentMessageBinding.inflate(inflater, view, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setScrollPositionToEnd()
        setListeners()
        setObservers()
        setAdapter()
    }

    private fun setListeners() {
        binding.messageSend.setOnClickListener {
            val message = binding.messageInput.text.toString()
            viewModel.doSendMessage(message)
        }

        binding.messageInput.setOnFocusChangeListener { _, _ ->
            CountDownTimer.getDelayMillis(500) {
                setScrollPositionToEnd()
            }
        }
    }

    private fun setObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiMessageEvent.collectLatest { result ->
                    when (result) {
                        is MessageViewModel.UiMessageEvent.ErrorMessage -> {
                            requireView().createSnackBarInFragment(result.message)
                        }
                        is MessageViewModel.UiMessageEvent.FailureMessage -> {
                            requireView().createSnackBarInFragment(result.throwable.message.toString())
                        }
                        is MessageViewModel.UiMessageEvent.LoadingMessage -> {
                            binding.messageLoading.isVisible = false
                        }
                        is MessageViewModel.UiMessageEvent.SendMessage -> {
                            binding.messageInput.text?.clear()
                            viewModel.getMessages()
                        }
                        is MessageViewModel.UiMessageEvent.UpdateMessage -> {
                            binding.messageInput.text?.clear()
                            viewModel.getMessages()
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiResponseEvent.collectLatest { result ->
                    when (result) {
                        is Resource.Error -> {
                            requireView().createSnackBarInFragment(result.message)
                        }
                        is Resource.Failure -> {
                            requireView().createSnackBarInFragment(result.throwable.message.toString())
                        }
                        is Resource.Loading -> {
                            binding.messageLoading.isVisible = false
                        }
                        is Resource.Success -> {
                            mainAdapter.items.clear()
                            mainAdapter.insertItems(result.data.data.messages)
                            setScrollPositionToEnd()
                        }
                    }
                }
            }
        }
    }

    private fun setAdapter() {
        binding.notificationRecyclerView.adapter = mainAdapter
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(context)

        mainAdapter.setOnLongClickListener(object : MessageAdapter.OnLongClickListener {
            override fun onLongClick(position: Int) {
                showDialogEditMessage(position)
            }
        })
    }

    private fun showDialogEditMessage(position: Int) {
        val message = when (val item = mainAdapter.items[position]) {
            is MessageAdapter.Messages.Left -> item.text
            is MessageAdapter.Messages.Right -> item.text
        }

        mainDialog.show(requireActivity().supportFragmentManager, "")
        mainDialog.setOnClickListener(object : MessageDialog.ClickListener {
            override fun onClick(text: String) {
                viewModel.doUpdateMessage(
                    when (val item = mainAdapter.items[position]) {
                        is MessageAdapter.Messages.Left -> MessageEditBody(
                            item.id, item.createdByStudent, text, item.guidanceId
                        )
                        is MessageAdapter.Messages.Right -> MessageEditBody(
                            item.id, item.createdByStudent, text, item.guidanceId
                        )
                    }
                )
            }

            override fun setFieldMessage() {
                mainDialog.insertInputFieldMessage(message)
            }
        })
    }

    private fun setScrollPositionToEnd() {
        if (mainAdapter.items.isNotEmpty()) {
            binding.notificationRecyclerView.smoothScrollToPosition(
                mainAdapter.items.size - 1
            )
        }
    }
}