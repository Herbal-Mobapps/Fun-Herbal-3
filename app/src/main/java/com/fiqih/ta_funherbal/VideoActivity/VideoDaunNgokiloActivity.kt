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

class VideoDaunNgokiloActivity : AppCompatActivity() {
    lateinit var mWebViewempatbelas: WebView
    val databaseempatbelas = FirebaseDatabase.getInstance().getReference("videoobatngokilo")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_ngokilo)
        mWebViewempatbelas = findViewById(R.id.webviewempatbelas)
        mWebViewempatbelas.settings.javaScriptEnabled = true

        mWebViewempatbelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databaseempatbelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messageempatbelas = snapshot.getValue(toString().javaClass)
                mWebViewempatbelas.loadUrl(messageempatbelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}