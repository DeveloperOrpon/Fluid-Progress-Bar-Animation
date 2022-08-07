package com.example.fluidslider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ramotion.fluidslider.FluidSlider
import kotlinx.android.synthetic.main.activity_main.*
const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val max = 100
        val min = 0
        val total = max - min
        val slider = findViewById<FluidSlider>(R.id.slider)
        slider.positionListener = { pos -> slider.bubbleText = "${min + (total  * pos).toInt()}" }
        slider.position = 0.3f
        slider.startText ="$min"
        slider.endText = "$max"
        slider.positionListener={ pos->
            Log.i(TAG,"positionListener : $pos")
            slider.bubbleText = "${min + (total  * pos).toInt()}"
        }
        slider.beginTrackingListener={
            Log.i(TAG,"beginTrackingListener")
        }
        slider.endTrackingListener={
            Log.i(TAG,"endTrackingListener")
        }

    }
}