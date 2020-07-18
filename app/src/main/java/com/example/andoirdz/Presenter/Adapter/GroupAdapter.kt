package com.example.andoirdz.Presenter.Adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.andoirdz.Domain.Student
import com.example.andoirdz.Domain.StudentsGroup
import com.example.andoirdz.Presenter.Activity.StudentsActivity
import com.example.andoirdz.Presenter.Fragment.GroupFragment
import com.example.andoirdz.Presenter.Fragment.StudentsFragment
import com.example.andoirdz.Presenter.Fragment.ViewPagerFragment
import com.example.andoirdz.Presenter.ViewHolder.GroupHolder
import com.example.andoirdz.R

class GroupAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    var context: Context? = null
    var groups: List<StudentsGroup>

    constructor(context: Context?, groups: List<StudentsGroup>) {
        this.context = context
        this.groups = groups
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.viewholder_group, parent, false)
        return GroupHolder(view)
    }

    override fun getItemCount(): Int {
        return groups.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GroupHolder).initiateBind(groups.get(position))

        (holder as GroupHolder).itemView.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            val fragment = StudentsFragment();
            bundle.putParcelable ("StudentsFragmentBundle", groups.get(position))
            fragment.setArguments(bundle)

            val fragmentManager: FragmentManager = (context as StudentsActivity).fragmentMenager
            fragmentManager?.beginTransaction()?.add(R.id.relativelayout_activity_students_fragment_container,
                fragment,"StudentsFragment")
                ?.hide((context as StudentsActivity).fragmentMenager.findFragmentByTag("ViewPagerFragment") as ViewPagerFragment)
                ?.addToBackStack(null)
                ?.commit()
        })
    }
}