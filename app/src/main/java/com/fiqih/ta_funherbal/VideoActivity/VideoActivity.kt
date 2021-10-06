package com.fiqih.ta_funherbal.VideoActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fiqih.ta_funherbal.R

class VideoActivity : AppCompatActivity() {
    private lateinit var btn_video_akarwangi : Button
    private lateinit var btn_video_bayam : Button
    private lateinit var btn_video_bayamduri : Button
    private lateinit var btn_video_belimbingwuluh : Button
    private lateinit var btn_video_blustru : Button
    private lateinit var btn_video_brotowali : Button
    private lateinit var btn_video_sambiloto : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        btn_video_akarwangi = findViewById(R.id.btn_video_akarwangi)
        btn_video_bayam = findViewById(R.id.btn_video_bayam)
        btn_video_bayamduri = findViewById(R.id.btn_video_bayamduri)
        btn_video_belimbingwuluh = findViewById(R.id.btn_video_belimbingwuluh)
        btn_video_blustru = findViewById(R.id.btn_video_blustru)
        btn_video_brotowali = findViewById(R.id.btn_video_brotowali)
        btn_video_sambiloto = findViewById(R.id.btn_video_daunsambiloto)

        btn_video_akarwangi.setOnClickListener {
            val intent = Intent(this,VideoAkarWangiActivity::class.java)
            startActivity(intent)
        }

        btn_video_bayam.setOnClickListener {
            val intent = Intent(this,VideoBayamActivity::class.java)
            startActivity(intent)
        }

        btn_video_bayamduri.setOnClickListener {
            val intent = Intent(this,VideoBayamDuriActivity::class.java)
            startActivity(intent)
        }

        btn_video_belimbingwuluh.setOnClickListener {
            val intent = Intent(this,VideoBelimbingWuluhActivity::class.java)
            startActivity(intent)
        }

        btn_video_blustru.setOnClickListener {
            val intent = Intent(this,VideoBlustruActivity::class.java)
            startActivity(intent)
        }

        btn_video_brotowali.setOnClickListener {
            val intent = Intent(this,VideoBrotowaliActivity::class.java)
            startActivity(intent)
        }
        btn_video_sambiloto.setOnClickListener {
            val intent = Intent(this,VideoDaunSambilotoActivity::class.java)
            startActivity(intent)
        }
    }

    }
