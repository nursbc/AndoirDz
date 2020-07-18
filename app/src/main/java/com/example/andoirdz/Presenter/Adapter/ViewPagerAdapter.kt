package com.example.andoirdz.Presenter.Adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Presentation.Fragment.NotesFragment
import com.example.andoirdz.Presenter.Activity.StudentsActivity
import com.example.andoirdz.Presenter.Fragment.GroupFragment
import com.example.andoirdz.Presenter.Fragment.StudentsFragment
import com.example.andoirdz.R

class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

    var fragmentList : MutableList<Fragment> = ArrayList()
    var titleList : MutableList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]

    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }

    fun addFragment(fragment : Fragment, title : String)
    {
        fragmentList.add(fragment)
        titleList.add(title)
    }
}
