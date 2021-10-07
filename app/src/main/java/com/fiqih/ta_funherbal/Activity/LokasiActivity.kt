package com.fiqih.ta_funherbal.Activity

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

class LokasiActivity : AppCompatActivity() {
    lateinit var mWebViewLokasi : WebView
    val databasekuis = FirebaseDatabase.getInstance().getReference("lokasi")
    @SuppressLint("SetJavaScriptEnabled")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lokasi)

        mWebViewLokasi = findViewById(R.id.webviewlokasi)
        mWebViewLokasi.settings.javaScriptEnabled = true

        mWebViewLokasi.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view!!.loadUrl(url.toString())
                return true
            }
        }
        databasekuis.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val messagelokasi = snapshot.getValue(toString().javaClass)
                mWebViewLokasi.loadUrl(messagelokasi.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}