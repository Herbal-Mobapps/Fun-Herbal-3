package com.fiqih.ta_funherbal.VideoActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.fiqih.ta_funherbal.R

class VideoActivity : AppCompatActivity() {
    private lateinit var btn_video_akarwangi: Button
    private lateinit var btn_video_bayam: Button
    private lateinit var btn_video_bayamduri: Button
    private lateinit var btn_video_belimbingwuluh: Button
    private lateinit var btn_video_blustru: Button
    private lateinit var btn_video_brotowali: Button
    private lateinit var btn_video_daundewa: Button
    private lateinit var btn_video_daunkelor: Button
    private lateinit var btn_video_daunmiana: Button
    private lateinit var btn_video_daunngokilo: Button
    private lateinit var btn_video_daunpacarcina: Button
    private lateinit var btn_video_daunpegangan: Button
    private lateinit var btn_video_daunsaga: Button
    private lateinit var btn_video_daunsambiloto : Button
    private lateinit var btn_video_daunsemanggi : Button
    private lateinit var btn_video_daunsembung : Button
    private lateinit var btn_video_daunsingkong : Button
    private lateinit var btn_video_daunsirih : Button
    private lateinit var btn_video_jahe : Button
    private lateinit var btn_video_jintanhitam : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        btn_video_akarwangi = findViewById(R.id.btn_video_akarwangi)
        btn_video_bayam = findViewById(R.id.btn_video_bayam)
        btn_video_bayamduri = findViewById(R.id.btn_video_bayamduri)
        btn_video_belimbingwuluh = findViewById(R.id.btn_video_belimbingwuluh)
        btn_video_blustru = findViewById(R.id.btn_video_blustru)
        btn_video_brotowali = findViewById(R.id.btn_video_brotowali)
        btn_video_daundewa = findViewById(R.id.btn_video_daundewa)
        btn_video_daunkelor = findViewById(R.id.btn_video_daunkelor)
        btn_video_daunmiana = findViewById(R.id.btn_video_daunmiana)
        btn_video_daunngokilo = findViewById(R.id.btn_video_daunngokilo)
        btn_video_daunpacarcina = findViewById(R.id.btn_video_daunpacarcina)
        btn_video_daunpegangan = findViewById(R.id.btn_video_daunpegangan)
        btn_video_daunsaga = findViewById(R.id.btn_video_daunsaga)
        btn_video_daunsambiloto = findViewById(R.id.btn_video_daunsambiloto)
        btn_video_daunsemanggi = findViewById(R.id.btn_video_daunsemanggi)
        btn_video_daunsembung = findViewById(R.id.btn_video_daunsembung)
        btn_video_daunsingkong = findViewById(R.id.btn_video_daunsingkong)
        btn_video_daunsirih = findViewById(R.id.btn_video_daunsirih)
        btn_video_jahe = findViewById(R.id.btn_video_jahe)
        btn_video_jintanhitam = findViewById(R.id.btn_video_jintanhitam)

        btn_video_akarwangi.setOnClickListener {
            val intent = Intent(this, VideoAkarWangiActivity::class.java)
            startActivity(intent)
        }

        btn_video_bayam.setOnClickListener {
            val intent = Intent(this, VideoBayamActivity::class.java)
            startActivity(intent)
        }

        btn_video_bayamduri.setOnClickListener {
            val intent = Intent(this, VideoBayamDuriActivity::class.java)
            startActivity(intent)
        }

        btn_video_belimbingwuluh.setOnClickListener {
            val intent = Intent(this, VideoBelimbingWuluhActivity::class.java)
            startActivity(intent)
        }

        btn_video_blustru.setOnClickListener {
            val intent = Intent(this, VideoBlustruActivity::class.java)
            startActivity(intent)
        }

        btn_video_brotowali.setOnClickListener {
            val intent = Intent(this, VideoBrotowaliActivity::class.java)
            startActivity(intent)
        }
        btn_video_daundewa.setOnClickListener {
            val intent = Intent(this, VideoDaunDewaActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunkelor.setOnClickListener {
            val intent = Intent(this, VideoDaunKelorActivity::class.java)
            startActivity(intent)
        }

        btn_video_daunmiana.setOnClickListener {
            val intent = Intent(this, VideoDaunMianaActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunngokilo.setOnClickListener {
            val intent = Intent(this, VideoDaunNgokiloActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunpacarcina.setOnClickListener {
            val intent = Intent(this, VideoDaunPacarCinaActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunpegangan.setOnClickListener {
            val intent = Intent(this, VideoDaunPeganganActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunsaga.setOnClickListener {
            val intent = Intent(this, VideoDaunSagaActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunsambiloto.setOnClickListener {
            val intent = Intent(this, VideoDaunSambilotoActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunsemanggi.setOnClickListener {
            val intent = Intent(this, VideoDaunSemanggiActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunsembung.setOnClickListener {
            val intent = Intent(this, VideoDaunSembungActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunsingkong.setOnClickListener {
            val intent = Intent(this, VideoDaunSingkongActivity::class.java)
            startActivity(intent)
        }
        btn_video_daunsirih.setOnClickListener {
            val intent = Intent(this, VideoDaunSirihActivity::class.java)
            startActivity(intent)
        }
        btn_video_jahe.setOnClickListener {
            val intent = Intent(this, VideoJaheActivity::class.java)
            startActivity(intent)
        }
        btn_video_jintanhitam.setOnClickListener {
            val intent = Intent(this, VideoJintanHitamActivity::class.java)
            startActivity(intent)
        }

    }
}
