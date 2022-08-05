package com.example.catcraft.ui.listframent.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.catcraft.databinding.CatBreedItemViewBinding
import com.example.catcraft.ui.listframent.datasource.model.CatBreedData
import com.example.catcraft.ui.listframent.ui.CatBreedAdapter.CatBreedViewHolder
import com.example.catcraft.utils.loadImageWithUrl

class CatBreedAdapter(private var itemCallback: (position: Int) -> Unit) :
    ListAdapter<CatBreedData, CatBreedViewHolder>(BreedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatBreedViewHolder {

        val binding = CatBreedItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CatBreedViewHolder(binding, itemCallback)

    }

    override fun onBindViewHolder(holder: CatBreedViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    class CatBreedViewHolder(private val binding: CatBreedItemViewBinding, itemCallback: (position: Int) -> Unit) :
        ViewHolder(binding.root) {

        init {
            binding.parentLayout.setOnClickListener {
                itemCallback(adapterPosition)
            }
        }

        fun bind(breedData: CatBreedData) {
            binding.recipeIv.loadImageWithUrl(breedData.image?.url)
            binding.recipeNameTv.text = breedData.name
            binding.lifeSpanTv.text = breedData.lifeSpan
        }

    }

}

class BreedDiffCallback : DiffUtil.ItemCallback<CatBreedData>() {
    override fun areItemsTheSame(oldItem: CatBreedData, newItem: CatBreedData): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CatBreedData, newItem: CatBreedData): Boolean {
        return oldItem == newItem
    }
}