package com.example.deli.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.deli.DataClass.PopularData
import com.example.deli.R

class FavoriteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_favorite, container, false)

        arguments?.let { bundle ->
            val burgerPhoto = bundle.getInt("burgerPhoto")
            val restaurantName = bundle.getString("restaurantName")
            val price = bundle.getString("how_much_money")
            val time = bundle.getString("time")
            val star = bundle.getString("star")

            rootView.findViewById<ImageView>(R.id.fav_food_image).setImageResource(burgerPhoto)
            rootView.findViewById<TextView>(R.id.fav_restaurant_name).text = restaurantName
            rootView.findViewById<TextView>(R.id.fav_how_mush_money_int).text = price
            rootView.findViewById<TextView>(R.id.fav_star_rating_string).text = star
            rootView.findViewById<TextView>(R.id.fav_time_to_ready_string).text = time
        }

        return rootView
    }
}