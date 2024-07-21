package com.example.islami

import Fragments.Hadeeth.HadeethFragment
import Fragments.Quran.QuranFragment
import Fragments.Radio.RadioFragment
import Fragments.Sebha.SebhaFragment
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islami.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()

    }

    private fun initViews() {
        binding.btmNavContant.btmNavBar.setOnItemSelectedListener { item ->
            val fragment: Fragment = when (item.itemId) {

                R.id.quran_fragment -> {
                    QuranFragment()
                }

                R.id.hadeeth_fragment -> {
                    HadeethFragment()
                }

                R.id.tasbeeh_fragment -> {
                    SebhaFragment()
                }

                R.id.radio_fragment -> {
                    RadioFragment()
                }

                else -> {
                    QuranFragment()
                }
            }
            pushFragments(fragment)
            true
        }
        binding.btmNavContant.btmNavBar.selectedItemId = R.id.quran_fragment
    }

    private fun pushFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragments_container, fragment)
            .commit()

    }
}