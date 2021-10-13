package com.fiqih.ta_funherbal.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fiqih.ta_funherbal.R
import com.fiqih.ta_funherbal.uitel.getProgessDrawable
import com.fiqih.ta_funherbal.uitel.loadImage
import kotlinx.android.synthetic.main.activity_tanaman2.*

class TanamanActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanaman2)

        val tanamanIntent = intent
        val tanamanName = tanamanIntent.getStringExtra("name")
        val tanamanInfo = tanamanIntent.getStringExtra("info")
        val tanamanImg = tanamanIntent.getStringExtra("img")

        /**call text and images*/
        name.text = tanamanName
        info.text = tanamanInfo
        img.loadImage(tanamanImg, getProgessDrawable(this))
    }
}