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

class VideoJintanHitamActivity : AppCompatActivity() {
    lateinit var mWebViewduapuluh: WebView
    val databaseduapuluh = FirebaseDatabase.getInstance().getReference("videojintanhitam")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_jintan_hitam)

        mWebViewduapuluh = findViewById(R.id.webviewduapuluh)
        mWebViewduapuluh.settings.javaScriptEnabled = true

        mWebViewduapuluh.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databaseduapuluh.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagesduapuluh = snapshot.getValue(toString().javaClass)
                mWebViewduapuluh.loadUrl(messagesduapuluh.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}