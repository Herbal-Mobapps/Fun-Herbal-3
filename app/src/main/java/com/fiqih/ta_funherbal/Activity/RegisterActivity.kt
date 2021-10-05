package com.fiqih.ta_funherbal.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.fiqih.ta_funherbal.MainActivity
import com.fiqih.ta_funherbal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var EmailRegister: EditText
    private lateinit var PasswordRegister: EditText
    private lateinit var ConfirmPasswordRegister: EditText
    private lateinit var btnLoginRegister: Button
    private lateinit var btnRegisterRegister: Button
    private lateinit var registerShowCheckBox: CheckBox
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        EmailRegister = findViewById(R.id.EmailRegister)
        PasswordRegister = findViewById(R.id.PasswordRegister)
        ConfirmPasswordRegister = findViewById(R.id.ConfirmPasswordRegister)
//        btnLoginRegister = findViewById(R.id.btnLoginRegister)
        btnRegisterRegister = findViewById(R.id.btnRegisterRegister)
        registerShowCheckBox = findViewById(R.id.registerShowCheckBox)

        registerShowCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                PasswordRegister.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                ConfirmPasswordRegister.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                PasswordRegister.transformationMethod = PasswordTransformationMethod.getInstance()
                ConfirmPasswordRegister.transformationMethod =
                    PasswordTransformationMethod.getInstance()
            }
        }

        btnRegisterRegister.setOnClickListener {
            val email = EmailRegister.text.toString()
            val password = PasswordRegister.text.toString()
            val confirmpassword = ConfirmPasswordRegister.text.toString()

            if (email.isNotEmpty() || password.isNotEmpty() || confirmpassword.isNotEmpty()) {
                if (password.equals(confirmpassword)) {

                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            val error = it.exception
                            error?.let {
                                Toast.makeText(this, "Error: ${it.message}", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }

                    }
                } else {
                    Toast.makeText(
                        this,
                        "Password and confirm password not match",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
//        btnLoginRegister.setOnClickListener {
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }
    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}