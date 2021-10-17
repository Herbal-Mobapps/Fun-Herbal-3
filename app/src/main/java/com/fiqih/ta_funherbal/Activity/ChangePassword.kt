package com.fiqih.ta_funherbal.Activity

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fiqih.ta_funherbal.Fragment.ProfileFragment
import com.fiqih.ta_funherbal.R
import com.google.firebase.auth.EmailAuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePassword : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        auth = FirebaseAuth.getInstance()
        btnSimpanPassBaru.setOnClickListener {
            gantipassword()
        }

        }

    private fun gantipassword() {
        if(etPasswordLama.text!!.isNotEmpty() &&
                etPasswordBaru.text!!.isNotEmpty() &&
               etKonfirmasiPassword.text!!.isNotEmpty()){
            if (etPasswordBaru.text.toString().equals(etKonfirmasiPassword.text.toString())){
                val user = auth.currentUser
                if (user != null && user.email != null){
                    val credential = EmailAuthProvider
                        .getCredential(user.email!!,etPasswordLama.text.toString())

                    user.reauthenticate(credential)
                        .addOnCompleteListener {
                            if (it.isSuccessful){
                                user.updatePassword(etPasswordBaru.text.toString())
                                    .addOnCompleteListener { task ->
                                    if (task.isSuccessful){
                                        Toast.makeText(this,"Password Berhasil Terganti",Toast.LENGTH_SHORT).show()
                                    auth.signOut()
                                        startActivity(Intent(this,LoginActivity::class.java))
                                        finish()
                                    }

                                    }
                                Toast.makeText(this,"Autentikasi Berhasil", Toast.LENGTH_SHORT).show()

                            }
                            else{
                                Toast.makeText(this,"Autentikasi Tidak Berhasil", Toast.LENGTH_SHORT).show()
                            }
                        }

                }else{
                   startActivity(Intent(this,LoginActivity::class.java))
                    finish()
                }
            }else{
                Toast.makeText(this,"Password tidak sama", Toast.LENGTH_SHORT).show()
            }
            }else{
            Toast.makeText(this,"Harap diisikan semua kolom yang tersedia",Toast.LENGTH_SHORT).show()
        }
    }
}