package com.example.deli

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.deli.Fragments.FavoriteFragment
import com.example.deli.Fragments.HomeFragment
import com.example.deli.Fragments.ProfileFragment
import com.example.deli.Fragments.TrashFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout


class MainMenuActivity : AppCompatActivity() {
    private lateinit var locText : TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        locText = findViewById(R.id.loc_text)
        locText.setOnClickListener{
            showPopMenu(it)
        }
        val homeButton = findViewById<BottomNavigationView>(R.id.nav_bar)
        val navigationView = findNavController(R.id.fragment_container)
        homeButton.setupWithNavController(navigationView)
    }
    fun showPopMenu(view: View){
        val popMenu = PopupMenu(this, view)
        popMenu.menuInflater.inflate(R.menu.menu, popMenu.menu)
        popMenu.setOnMenuItemClickListener { item ->
            when(item.itemId){
                R.id.Kaskelen ->{locText.text = item.title
                    true}
                R.id.Almaty ->{locText.text = item.title
                    true}
                R.id.Astana ->{locText.text = item.title
                    true}
                R.id.Shamalgan ->{locText.text = item.title
                    true}
                R.id.Shymkent ->{locText.text = item.title
                    true}
                R.id.Aqtau ->{locText.text = item.title
                    true}
                else -> {false}
             }
         }
         popMenu.show()
     }
}