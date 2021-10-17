package com.fiqih.ta_funherbal.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import com.fiqih.ta_funherbal.MainActivity
import com.fiqih.ta_funherbal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var EmailLogin: EditText
    private lateinit var PasswordLogin: EditText
    private lateinit var btnLoginLogin: Button
    private lateinit var btnRegisterLogin: TextView
    private lateinit var LoginCheckBox: CheckBox
    private lateinit var lupapasswordTV : TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth
        EmailLogin = findViewById(R.id.EmailLogin)
        PasswordLogin = findViewById(R.id.PasswordLogin)
        btnLoginLogin = findViewById(R.id.btnLoginLogin)
        btnRegisterLogin = findViewById(R.id.btnRegisterLogin)
        LoginCheckBox = findViewById(R.id.loginShowCheckBox)
        lupapasswordTV = findViewById(R.id.lupapasswordTV)

        LoginCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                PasswordLogin.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                PasswordLogin.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }

        btnLoginLogin.setOnClickListener {
            val email = EmailLogin.text.toString()
            val password = PasswordLogin.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()) {

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val error = it.exception
                        error?.let {
                            Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
        btnRegisterLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        lupapasswordTV.setOnClickListener {
            Intent(this@LoginActivity,ResetPassword::class.java).also{
                startActivity(it)
            }
        }
    }
}