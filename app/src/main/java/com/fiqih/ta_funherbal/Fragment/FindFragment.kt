package com.fiqih.ta_funherbal.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.fiqih.ta_funherbal.Activity.KuisActivity
import com.fiqih.ta_funherbal.Activity.LokasiActivity
import com.fiqih.ta_funherbal.Adapter.AdapterSlider
import com.fiqih.ta_funherbal.R
import com.fiqih.ta_funherbal.TanamanActivity
import com.fiqih.ta_funherbal.VideoActivity.VideoActivity
import com.fiqih.ta_funherbal.databinding.FragmentFindBinding
import kotlinx.android.synthetic.main.fragment_find.*

class FindFragment : Fragment() {

    lateinit var vpSlider: ViewPager
    private var _binding : FragmentFindBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // image slider
        val view: View = inflater.inflate(R.layout.fragment_find, container, false)

        vpSlider = view.findViewById(R.id.vp_slider)

        val arrSlider = ArrayList<Int>()
        arrSlider.add(R.drawable.iconlogo)
        arrSlider.add(R.drawable.icon_regis)
        arrSlider.add(R.drawable.iconlogo)

        val adapterSlider = AdapterSlider(arrSlider,activity)
        vpSlider.adapter = adapterSlider
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFindBinding.bind(view)

        binding?.btnTanaman?.setOnClickListener {
            val intent = Intent(this@FindFragment.requireContext(),TanamanActivity::class.java)
            startActivity(intent)
        }
        binding?.btnVideo?.setOnClickListener {
            val intent = Intent(this@FindFragment.requireContext(), VideoActivity::class.java)
            startActivity(intent)
        }
        binding?.btnKuis?.setOnClickListener {
            val intent = Intent(this@FindFragment.requireContext(),KuisActivity::class.java)
            startActivity(intent)
        }
        binding?.btnLokasi?.setOnClickListener {
            val intent = Intent(this@FindFragment.requireContext(),LokasiActivity::class.java)
            startActivity(intent)
        }

    }
}