package com.booknest.community.activity

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.booknest.community.R
import com.booknest.community.fragment.CheckoutFragment
import com.booknest.community.fragment.ExploreFragment
import com.booknest.community.fragment.HomeFragment
import com.booknest.community.fragment.OrderFragment
import com.booknest.community.fragment.ProfileFragment
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bottom: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val fragmentId = R.id.fragmentContainerView

        val colorStateList = ColorStateList(
            arrayOf(
                intArrayOf(android.R.attr.state_checked),
                intArrayOf(-android.R.attr.state_checked)
            ),
            intArrayOf(
                getColor(R.color.primary),
                getColor(R.color.light_grey)
            )
        )

        bottom.itemTextColor = colorStateList;
        bottom.itemIconTintList = colorStateList;

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(fragmentId, HomeFragment())
                .commit()
        }
        bottom.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_explore -> ExploreFragment()
                R.id.nav_orders -> OrderFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> null
            }

            fragment?.let {
                supportFragmentManager.beginTransaction().replace(fragmentId, it).commit()
                true
            } ?: false
        }


    }


}