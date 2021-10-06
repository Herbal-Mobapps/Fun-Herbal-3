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

class VideoDaunSagaActivity : AppCompatActivity() {
    lateinit var mWebViewtujuhbelas: WebView
    val databasetujuhbelas = FirebaseDatabase.getInstance().getReference("videodaunsaga")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_daun_saga)

        mWebViewtujuhbelas = findViewById(R.id.webviewtujuhbelas)
        mWebViewtujuhbelas.settings.javaScriptEnabled = true

        mWebViewtujuhbelas.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databasetujuhbelas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagetujuhbelas = snapshot.getValue(toString().javaClass)
                mWebViewtujuhbelas.loadUrl(messagetujuhbelas.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}