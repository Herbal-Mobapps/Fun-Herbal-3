package com.fiqih.ta_funherbal.Activity

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import com.fiqih.ta_funherbal.MainActivity
import com.fiqih.ta_funherbal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var logoImageView: ImageView
    private lateinit var titleTextView: TextView

    private lateinit var auth: FirebaseAuth
    private val animationTime: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        auth = Firebase.auth
        logoImageView = findViewById(R.id.splashlogoIV)
        titleTextView = findViewById(R.id.JudulSpalsh)


        val animatorY = ObjectAnimator.ofFloat(logoImageView, "y", 400f)
        val animatorX = ObjectAnimator.ofFloat(R.id.JudulSpalsh, "x", 200f )

        animatorY.setDuration(animationTime)
        animatorX.setDuration(animationTime)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(animatorY, animatorX)
        animatorSet.start()
    }
    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            if (currentUser != null) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }, 4000)
    }

}