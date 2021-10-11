package com.fiqih.ta_funherbal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fiqih.ta_funherbal.Fragment.FindFragment
import com.fiqih.ta_funherbal.Fragment.HomeFragment
import com.fiqih.ta_funherbal.Fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentcontainer, fragment)
            commit()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FindFragment()
        val secondFragment = ProfileFragment()



        setCurrentFragment(firstFragment)
        bottomNavigation = findViewById(R.id.navbottom)
        @Suppress("DEPRECATION")
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.navigation_find -> setCurrentFragment(firstFragment)
                R.id.navigation_profile -> setCurrentFragment(secondFragment)

            }
            true
        }

    }
}