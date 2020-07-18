package com.example.andoirdz.Presenter.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.andoirdz.Presenter.Base.baseActivity.BaseActivity
import com.example.andoirdz.Presenter.Fragment.GroupFragment
import com.example.andoirdz.Presenter.Fragment.StudentsFragment
import com.example.andoirdz.R

class StudentsActivity : BaseActivity() {
    override var currentFragment: Fragment? = null
    override lateinit var fragmentMenager : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeFragmentManager()
        initializeDefaultFragment()
    }

    override fun initializeFragmentManager(){
        fragmentMenager = supportFragmentManager

    }

    override fun initializeDefaultFragment(){
        if(currentFragment==null){
            currentFragment = GroupFragment()

        }

        displayFragment(currentFragment!!)
    }

    override fun displayFragment(fragment : Fragment) {
        fragmentMenager.beginTransaction()
            .add(R.id.relativelayout_activity_students_fragment_container,fragment!!, "GroupFragment")
            .commit()
    }

    override fun returnActivityInctance() {
        return returnActivityInctance()
    }

}