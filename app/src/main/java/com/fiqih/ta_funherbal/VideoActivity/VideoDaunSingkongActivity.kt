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

class VideoDaunSingkongActivity : AppCompatActivity() {
    lateinit var mWebViewdelapanbelas: WebView
    val databasedelapanbelas = FirebaseDatabase.getInstance().getReference("videodaunsingkong")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_singkong)

        mWebViewdelapanbelas = findViewById(R.id.webviewdelapanbelas)
        mWebViewdelapanbelas.settings.javaScriptEnabled = true

        mWebViewdelapanbelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databasedelapanbelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagedelapanbelas = snapshot.getValue(toString().javaClass)
                mWebViewdelapanbelas.loadUrl(messagedelapanbelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}