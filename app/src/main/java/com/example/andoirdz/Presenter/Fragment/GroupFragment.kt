package com.example.andoirdz.Presenter.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Presenter.Adapter.GroupAdapter
import com.example.andoirdz.Presenter.Contract.IGroupFragmentContract
import com.example.andoirdz.Presenter.Presenters.GroupFragmentPresenter
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.fragment_groups.*

class GroupFragment : Fragment(), View.OnClickListener, IGroupFragmentContract.View  {

    var studentsGroup : ArrayList<StudentsGroup> = ArrayList()

    var groupAdapter : GroupAdapter? = null

    lateinit var presenter : GroupFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_groups, container, false)

        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeListeners()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        presenter.initializeData()

        test()
    }

    fun test()
    {
        for (g in studentsGroup)
        {
            for(s in g.students)
            {
                if(s.studentGroup == g.title)
                {
                    Log.d("Student", s.toString())
                    return
                }
            }
        }
    }


    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.button_update_fragment_group -> {
                initiateUpdateAdapter()
            }
        }
    }

    override fun initializePresenter() {
        presenter = GroupFragmentPresenter()
        presenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerview_fragment_group?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        groupAdapter = GroupAdapter(context, studentsGroup)
        recyclerview_fragment_group?.adapter = groupAdapter
    }

    override fun initiateUpdateAdapter() {
        groupAdapter?.notifyDataSetChanged()
    }

    override fun processData(groups: ArrayList<StudentsGroup>) {
        this.studentsGroup.clear()
        this.studentsGroup.addAll(groups)
    }

    override fun initializeViews() {
        TODO("Not yet implemented")
    }

    override fun initializeListeners() {
        button_update_fragment_group.setOnClickListener(this)
    }

    override fun initializeArguments() {
        TODO("Not yet implemented")
    }

    override fun initializeDependencies() {
        TODO("Not yet implemented")
    }
}