package com.example.deli.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.deli.Adapters.ImageSliderAdapter
import com.example.deli.Adapters.PopularAdapter
import com.example.deli.DataClass.ItemData
import com.example.deli.DataClass.PopularData
import com.example.deli.R

class HomeFragment : Fragment(){
    private lateinit var recyclerView: RecyclerView
    private lateinit var listItem: ArrayList<PopularData>
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: ImageSliderAdapter
    private lateinit var imageList: ArrayList<ItemData>
    private lateinit var handler: Handler
    private lateinit var heart_image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager2 = view.findViewById(R.id.view_pager)
        recyclerView = view.findViewById(R.id.home_recyclerView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setTransformer()
        initRecyclerView()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)
            }
        })
    }

    private val runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }

    private fun setTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(0))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 5000)
    }

    private fun init() {
        imageList = ArrayList()
        imageList.run {
            add(ItemData(R.drawable.bahandi, "Bahandi", "1+1"))
            add(ItemData(R.drawable.doner, "Sultani Mix", "-20%"))
            add(ItemData(R.drawable.pizza, "DodoPizza", "-40%"))
            add(ItemData(R.drawable.kfc, "KFC", "-30%"))
        }
        adapter = ImageSliderAdapter(requireContext(), imageList, viewPager2)
        handler = Handler(Looper.myLooper()!!)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipChildren = false
        viewPager2.clipToPadding = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_ALWAYS
    }

    private fun initRecyclerView() {
        listItem = ArrayList()
        listItem.run {
            add(PopularData(R.drawable.burger_photo, "Bahandi", " 500тг", "20-30 мин", "4.8"))
            add(PopularData(R.drawable.doner_photo2, "Sultani Mix", " 800тг", "20-30 мин", "4.9"))
            add(PopularData(R.drawable.pizza_photo, "DodoPizza", " 750тг", "20-30 мин", "4.5"))
            add(PopularData(R.drawable.kfc_photo2, "KFC", " 950тг", "20-30 мин", "5"))
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = PopularAdapter(requireContext(), listItem)
        recyclerView.adapter = adapter
    }

}