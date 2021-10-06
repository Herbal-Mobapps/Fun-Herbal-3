package com.fiqih.ta_funherbal.VideoActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.fiqih.ta_funherbal.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class VideoAkarWangiActivity : AppCompatActivity() {
    lateinit var mWebViewSatu : WebView

    val databasesatu = FirebaseDatabase.getInstance().getReference("videoakarwangi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_akar_wangi)

        mWebViewSatu = findViewById(R.id.webviewsatu)
        mWebViewSatu.settings.javaScriptEnabled = true

        mWebViewSatu.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databasesatu.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagesatu = snapshot.getValue(toString().javaClass)
                mWebViewSatu.loadUrl(messagesatu.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    }
