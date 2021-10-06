package com.fiqih.ta_funherbal.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import com.fiqih.ta_funherbal.Activity.KuisActivity
import com.fiqih.ta_funherbal.VideoActivity.VideoActivity
import com.fiqih.ta_funherbal.databinding.FragmentFindBinding

class FindFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bind = FragmentFindBinding.inflate(layoutInflater)
        bind.btnVideo.setOnClickListener {
            val intent = Intent(this@FindFragment.requireContext(), VideoActivity::class.java)
            startActivity(intent)
        }
        bind.btnKuis.setOnClickListener {
            val intent = Intent(this@FindFragment.requireContext(),KuisActivity::class.java)
            startActivity(intent)
        }
        return bind.root
    }
}