package com.example.andoirdz.Presenter.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Presentation.Fragment.NotesFragment
import com.example.andoirdz.Presenter.Adapter.ViewPagerAdapter
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.fragment_viewpager.*

class ViewPagerFragment : Fragment() {

    var students: ArrayList<Student> = ArrayList()
    var adapter : ViewPagerAdapter? = null
    var rootView : View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_viewpager, container, false)

        return  rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeAdapter()
    }

    fun initializeAdapter()
    {
        this.adapter = getFragmentManager()?.let { ViewPagerAdapter(it) }
        adapter?.addFragment(GroupFragment(), "Group")
        adapter?.addFragment(NotesFragment(), "Notes Fragment")


        viewpager_fragment_viewpager?.adapter = adapter
        tabs_fragment_viewpager?.setupWithViewPager(viewpager_fragment_viewpager)
    }

}

