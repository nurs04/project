package com.example.deli.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.deli.DataClass.ItemData
import com.example.deli.Interfaces.OnItemClickListener
import com.example.deli.R

class ImageSliderAdapter(
    private val context: Context,
    private val imageList: ArrayList<ItemData>,
    private val viewPager2: ViewPager2,
) : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageSliderAdapter.ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_container, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageSliderAdapter.ImageViewHolder, position: Int) {
        val currentPosition = imageList[position % imageList.size]
        holder.image.setImageResource(currentPosition.imageResId)
        holder.textOverlay.text =  currentPosition.text
        holder.discountButton.text = currentPosition.discount


    }

    override fun getItemCount() = imageList.size

    class ImageViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.imageInContainer)
        val textOverlay = itemView.findViewById<TextView>(R.id.textOverlay)
        val discountButton = itemView.findViewById<Button>(R.id.dicount_btn)
    }

}