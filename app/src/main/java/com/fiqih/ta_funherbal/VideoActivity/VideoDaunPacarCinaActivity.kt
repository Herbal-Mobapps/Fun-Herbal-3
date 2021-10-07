package com.fiqih.ta_funherbal.VideoActivity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.fiqih.ta_funherbal.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class VideoDaunPacarCinaActivity : AppCompatActivity() {
    lateinit var mWebViewlimabelas: WebView
    val databaselimabelas = FirebaseDatabase.getInstance().getReference("videodaunpacarcina")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_pacar_cina)

        mWebViewlimabelas = findViewById(R.id.webviewlimabelas)
        mWebViewlimabelas.settings.javaScriptEnabled = true

        mWebViewlimabelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databaselimabelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagelimabelas = snapshot.getValue(toString().javaClass)
                mWebViewlimabelas.loadUrl(messagelimabelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}