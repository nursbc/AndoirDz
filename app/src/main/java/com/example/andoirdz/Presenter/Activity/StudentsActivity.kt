package com.example.andoirdz.Presenter.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.andoirdz.Presenter.Fragment.GroupFragment
import com.example.andoirdz.Presenter.Fragment.StudentsFragment
import com.example.andoirdz.R

class StudentsActivity : AppCompatActivity() {
    var currentFragment: Fragment? = null
    lateinit var fragmentMenager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeFragmentManager()
        initializeDefaultFragment()
    }

    fun initializeFragmentManager(){
        fragmentMenager = supportFragmentManager

    }

    fun initializeDefaultFragment(){
        if(currentFragment==null){
            currentFragment = GroupFragment()

            fragmentMenager.beginTransaction()
                .add(R.id.relativelayout_activity_students_fragment_container,currentFragment!!,"GroupFragment")
                .commit()
        }
    }
}