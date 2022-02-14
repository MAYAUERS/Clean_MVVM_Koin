package com.example.clean_arch_with_koin.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.clean_arch_with_koin.databinding.CoctailItemsBinding
import com.example.clean_arch_with_koin.domain.model.Drinks
import com.squareup.picasso.Picasso

class CoctailAdapter:RecyclerView.Adapter<CoctailAdapter.CocatailViewHolder>() {

    var drinks : List<Drinks> = ArrayList<Drinks>()
    private val picasso: Picasso = Picasso.get()
    class CocatailViewHolder(val binding: CoctailItemsBinding) :RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CoctailAdapter.CocatailViewHolder {
        var binding = CoctailItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CocatailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoctailAdapter.CocatailViewHolder, position: Int) {
        holder.binding.tvName.text= drinks[position].strDrink
        holder.binding.tvCategory.text= drinks[position].strCategory
        var imageUri=drinks[position].strDrinkThumb
        picasso.load(imageUri)
            .into(holder.binding.imgCoctails)

    }

    override fun getItemCount(): Int {
        return drinks.size
    }



}