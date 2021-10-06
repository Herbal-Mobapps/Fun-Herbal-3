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

class VideoDaunPeganganActivity : AppCompatActivity() {
    lateinit var mWebViewenambelas: WebView
    val databaseenambelas = FirebaseDatabase.getInstance().getReference("videodaunpegagan")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_pegangan)

        mWebViewenambelas = findViewById(R.id.webviewenambelas)
        mWebViewenambelas.settings.javaScriptEnabled = true

        mWebViewenambelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databaseenambelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messageenambelas = snapshot.getValue(toString().javaClass)
                mWebViewenambelas.loadUrl(messageenambelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}