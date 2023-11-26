package com.example.deli.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.deli.DataClass.PopularData
import com.example.deli.Fragments.FavoriteFragment
import com.example.deli.R

class PopularAdapter(
    private val context: Context,
    private val listItem : ArrayList<PopularData>,

) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularAdapter.PopularViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_food_item, parent, false)
        return PopularViewHolder(view)
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: PopularAdapter.PopularViewHolder, position: Int) {
        val currentPosition = listItem[position]
        holder.image.setImageResource(currentPosition.image)
        holder.resName.text = currentPosition.nameOfRestaurant
        holder.price.text = currentPosition.price
        holder.time.text = currentPosition.timeToReady
        holder.star.text = currentPosition.rating

        holder.heartPhoto.setOnClickListener {
            val currentItem = listItem[position]
            val bundle = Bundle().apply {
                putInt("burgerPhoto", currentItem.image)
                putString("restaurantName", currentItem.nameOfRestaurant)
                putString("how_much_money", currentItem.price)
                putString("time", currentItem.timeToReady)
                putString("star", currentItem.rating)
            }

            val favoriteFragment = FavoriteFragment()
            favoriteFragment.arguments = bundle
            val activity = context as AppCompatActivity
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, favoriteFragment)
                .addToBackStack(null)
                .commit()
        }
    }
    class PopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.home_food_image)
        val resName = view.findViewById<TextView>(R.id.restaurant_name)
        val price = view.findViewById<TextView>(R.id.how_mush_money_int)
        val time = view.findViewById<TextView>(R.id.time_to_ready_string)
        val star = view.findViewById<TextView>(R.id.star_rating_string)
        val heartPhoto = view.findViewById<ImageView>(R.id.heart_photoForFavFragment)

        }
    }