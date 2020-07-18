package com.example.andoirdz.Presenter.Base.baseActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.andoirdz.Presenter.Fragment.GroupFragment
import com.example.andoirdz.R

abstract class BaseActivity : AppCompatActivity() {

    open var currentFragment: Fragment? = null
    open lateinit var fragmentMenager : FragmentManager


    abstract fun initializeFragmentManager()

    abstract fun initializeDefaultFragment()

    abstract fun displayFragment(fragment : Fragment)

    abstract fun returnActivityInctance()

}