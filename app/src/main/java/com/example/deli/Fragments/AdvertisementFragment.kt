package com.example.deli.Fragments

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.deli.R

class AdvertisementFragment : Fragment() {
    private lateinit var timer: CountDownTimer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_advertisement, container, false)

        val progressBarTimer: ProgressBar = view.findViewById(R.id.progressBarTimer)
        val buttonClose: ImageView = view.findViewById(R.id.x_image)

        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 1000).toInt()
                progressBarTimer.progress = progress
            }

            override fun onFinish() {
                childFragmentManager.beginTransaction().remove(this@AdvertisementFragment).commit()
            }
        }.start()

        buttonClose.setOnClickListener {
            childFragmentManager.beginTransaction().remove(this@AdvertisementFragment).commit()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }
}
