package ru.vsu.zmaev.cocktailbar.presentation.screen.mycocktails.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.vsu.zmaev.cocktailbar.R
import ru.vsu.zmaev.cocktailbar.databinding.RvItemCocktailBinding
import ru.vsu.zmaev.cocktailbar.domain.model.Cocktail

class CocktailListAdapter(
    val onClickRead: (Cocktail) -> Unit
) : ListAdapter<Cocktail, CocktailListAdapter.ViewHolder>(
    DiffUtilCallback
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RvItemCocktailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: RvItemCocktailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cocktail: Cocktail) {
//            binding.cocktailPicIv.setImageURI(cocktail.imagePath.toUri())
            binding.cocktailIv.setImageResource(R.drawable.cocktail_sample)
            binding.nameTv.text = cocktail.name
        }
    }

    private object DiffUtilCallback : DiffUtil.ItemCallback<Cocktail>() {
        override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail): Boolean =
            oldItem == newItem
    }
}