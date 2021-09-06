package com.example.projectinsquare.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.projectinsquare.R
import com.example.projectinsquare.data.Venue
import javax.inject.Inject

class VenueAdapter @Inject constructor() :
    ListAdapter<Venue, VenueAdapter.VenueViewHolder>(DIFF_CALLBACK) {

    private var onClick: ((Venue) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VenueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.venue_row_item, parent, false)

        return VenueViewHolder(view) { position -> onClick?.invoke(getItem(position)) }
    }

    override fun onBindViewHolder(holder: VenueViewHolder, position: Int) {
        holder.nameView.text = getItem(position).name
        holder.addressView.text = getItem(position).location.addressIfAny
    }

    fun setOnClickListener(onClickHandler: (Venue) -> Unit) {
        onClick = onClickHandler
    }

    class VenueViewHolder(view: View, private val onClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.name)
        val addressView: TextView = view.findViewById(R.id.address)

        init {
            view.setOnClickListener { onClick(adapterPosition) }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Venue>() {
            override fun areItemsTheSame(oldItem: Venue, newItem: Venue) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Venue, newItem: Venue) =
                oldItem.name == newItem.name
        }
    }
}

