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

class VideoDaunMianaActivity : AppCompatActivity() {
    lateinit var mWebViewtigabelas: WebView
    val databasetigabelas = FirebaseDatabase.getInstance().getReference("videodaunmiana")

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_miana)

        mWebViewtigabelas = findViewById(R.id.webviewtigabelas)
        mWebViewtigabelas.settings.javaScriptEnabled = true

        mWebViewtigabelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databasetigabelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagetigabelas = snapshot.getValue(toString().javaClass)
                mWebViewtigabelas.loadUrl(messagetigabelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}