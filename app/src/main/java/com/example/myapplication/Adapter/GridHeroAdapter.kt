package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.Hero
import com.example.myapplication.R

class GridHeroAdapter(val listHero: ArrayList<Hero>) :
    RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_grid_hero, parent, false)
        return GridViewHolder(view)
    }


    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listHero[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu Memilih "+listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listHero.size
    }


    private lateinit var onItemClickCallback: GridHeroAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: GridHeroAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}