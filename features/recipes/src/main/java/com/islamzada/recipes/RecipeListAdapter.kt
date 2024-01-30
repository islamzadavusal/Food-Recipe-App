package com.islamzada.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.islamzada.entities.uimodel.RecipeListUIModel
import com.islamzada.recipes.databinding.RecipeListItemBinding
import com.squareup.picasso.Picasso

class RecipeListAdapter : RecyclerView.Adapter<RecipeListViewHolder>() {

    private val differ = AsyncListDiffer(this, differCallBack)

    fun setData(items: List<RecipeListUIModel>){
        differ.submitList(items)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val bind = RecipeListItemBinding.inflate(inflater,parent,false)

        return RecipeListViewHolder(bind)

    }

    override fun onBindViewHolder(holder: RecipeListViewHolder, position: Int) {
        differ.currentList.getOrNull(position)?.let {
            holder.bind(it)
        }

    }


    companion object {
        private val differCallBack = object : DiffUtil.ItemCallback<RecipeListUIModel>(){
            override fun areItemsTheSame(oldItem: RecipeListUIModel, newItem: RecipeListUIModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RecipeListUIModel, newItem: RecipeListUIModel): Boolean {
                return oldItem == newItem
            }

        }
    }


}


class RecipeListViewHolder(private val binding : RecipeListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(viewModel: RecipeListUIModel){
        binding.txtTitle.text = viewModel.title

        Picasso.get().load(viewModel.image).into(binding.imageView)    }
}