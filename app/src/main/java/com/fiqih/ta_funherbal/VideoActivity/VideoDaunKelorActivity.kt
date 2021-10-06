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

class VideoDaunKelorActivity : AppCompatActivity() {
    lateinit var mWebViewduabelas: WebView
    val databaseduabelas = FirebaseDatabase.getInstance().getReference("videodaunkelor")

    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_kelor)

        mWebViewduabelas = findViewById(R.id.webviewduabelas)
        mWebViewduabelas.settings.javaScriptEnabled = true

        mWebViewduabelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databaseduabelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messageduabelas = snapshot.getValue(toString().javaClass)
                mWebViewduabelas.loadUrl(messageduabelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}