package com.example.androidweek_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidweek_4.model.Image
import androidx.recyclerview.widget.ListAdapter

class RestaurantAdapterGrid : RecyclerView.Adapter<RestaurantAdapterGrid.ViewHolder>() {

    var images: ArrayList<Image>  = ArrayList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //val imageView: ImageView = itemView.findViewById(R.id.iv_avatar)

        fun bindData(image: Image) {
            val tvTitle = itemView.findViewById<TextView>(R.id.tv_titleg);
            val tvDescription = itemView.findViewById<TextView>(R.id.tv_descriptiong)
            val ivAvatar = itemView.findViewById<ImageView>(R.id.iv_avatarg)
            tvTitle.text = image.name
            tvDescription.text = image.address
            Glide.with(itemView.context).load(image.link).centerCrop().into(ivAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.restaurant_item_grid, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder.bindData(image)
        //Glide.with(holder.itemView).load(image.link).centerCrop().into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    fun setData(data : List<Image>) {
        images.clear()
        images.addAll(data)
        notifyDataSetChanged()
    }
}
