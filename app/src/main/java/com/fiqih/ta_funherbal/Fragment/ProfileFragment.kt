package com.fiqih.ta_funherbal.Fragment

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Camera
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fiqih.ta_funherbal.Activity.LoginActivity
import com.fiqih.ta_funherbal.R
import com.fiqih.ta_funherbal.TanamanActivity
import com.fiqih.ta_funherbal.databinding.FragmentFindBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_profile.*
import java.io.ByteArrayOutputStream




class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters


    private lateinit var imageUri : Uri

    private lateinit var auth : FirebaseAuth

    companion object{
        const val REQUEST_CAMERA = 100
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        keluarTV.setOnClickListener {
            auth.signOut()
            val intent = Intent(this@ProfileFragment.requireContext(), LoginActivity::class.java)
            startActivity(intent)

        }


        imgCamera.setOnClickListener {
            intentCamera()
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun intentCamera() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            activity?.packageManager?.let {
                intent.resolveActivity(it).also {
                    @Suppress("DEPRECATION")
                    startActivityForResult(intent, REQUEST_CAMERA)
                }
            }
        }
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CAMERA && resultCode == RESULT_OK){
            val imgBitmap = data?.extras?.get("data") as Bitmap
            uploadImage(imgBitmap)
        }
    }

    private fun uploadImage(imgBitmap: Bitmap) {
            val baos = ByteArrayOutputStream()
            val ref = FirebaseStorage.getInstance().reference.child("img/${FirebaseAuth.getInstance().currentUser?.uid}")

        imgBitmap.compress(Bitmap.CompressFormat.JPEG,100, baos)
        val image = baos.toByteArray()

        ref.putBytes(image)
            .addOnCompleteListener(){
                if(it.isSuccessful){
                    ref.downloadUrl.addOnCompleteListener {
                        it.result?.let {
                            imageUri = it
                            imgProfile.setImageBitmap(imgBitmap)
                        }
                    }
                }
            }

    }

}
