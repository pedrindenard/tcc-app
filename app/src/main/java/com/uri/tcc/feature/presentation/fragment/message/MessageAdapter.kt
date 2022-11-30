package com.uri.tcc.feature.presentation.fragment.message

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.uri.tcc.R
import com.uri.tcc.databinding.ItemSenderLeftMessageBinding
import com.uri.tcc.databinding.ItemSenderRightMessageBinding
import com.uri.tcc.feature.domain.model.message.Message
import com.uri.tcc.utils.StringFormat.formatToDate

class MessageAdapter : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    private lateinit var onLongClickListener: OnLongClickListener

    val items = arrayListOf<Messages>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            R.layout.item_sender_right_message -> ViewHolder.Right(
                ItemSenderRightMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
            R.layout.item_sender_left_message -> ViewHolder.Left(
                ItemSenderLeftMessageBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
            )
            else -> {
                throw IllegalArgumentException("Invalid view type provided")
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.Right -> {
                holder.bind(items[position] as Messages.Right)
            }
            is ViewHolder.Left -> {
                holder.bind(items[position] as Messages.Left)
            }
        }
        holder.onLongClickListener = onLongClickListener
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Messages.Left -> R.layout.item_sender_left_message
            is Messages.Right -> R.layout.item_sender_right_message
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    sealed class ViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        lateinit var onLongClickListener: OnLongClickListener

        class Right(private val binding: ItemSenderRightMessageBinding) : ViewHolder(binding) {
            fun bind(message: Messages.Right) {
                binding.personMessage.text = message.text
                binding.personDate.text = message.createdAt.formatToDate()

                binding.personView.setOnLongClickListener {
                    onLongClickListener.onLongClick(absoluteAdapterPosition)
                    false
                }
            }
        }

        class Left(private val binding: ItemSenderLeftMessageBinding) : ViewHolder(binding) {
            fun bind(message: Messages.Left) {
                binding.personMessage.text = message.text
                binding.personDate.text = message.createdAt.formatToDate()

                binding.personView.setOnLongClickListener {
                    onLongClickListener.onLongClick(absoluteAdapterPosition)
                    false
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun insertItems(newList: List<Message>) {
        newList.forEach { message ->
            items.add(
                if (message.createdByStudent) Messages.Left(
                    message.id, message.createdAt, message.createdByStudent,
                    message.text, message.guidanceId
                ) else Messages.Right(
                    message.id, message.createdAt, message.createdByStudent,
                    message.text, message.guidanceId
                )
            )
        }
        notifyDataSetChanged()
    }

    fun setOnLongClickListener(mOnLongClickListener: OnLongClickListener) {
        onLongClickListener = mOnLongClickListener
    }

    sealed class Messages {

        data class Right(
            val id: String,
            val createdAt: String,
            val createdByStudent: Boolean,
            val text: String,
            val guidanceId: String
        ) : Messages()

        data class Left(
            val id: String,
            val createdAt: String,
            val createdByStudent: Boolean,
            val text: String,
            val guidanceId: String
        ) : Messages()
    }

    interface OnLongClickListener {
        fun onLongClick(position: Int)
    }
}