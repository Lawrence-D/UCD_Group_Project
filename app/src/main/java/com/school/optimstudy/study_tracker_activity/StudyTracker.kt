package com.school.optimstudy.study_tracker_activity

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.school.optimstudy.R
import kotlinx.android.synthetic.main.activity_study_tracker.*
import kotlinx.android.synthetic.main.activity_study_tracker.view.*

class StudyTracker : Fragment() {
    companion object {
        fun newInstance(): StudyTracker {
            return StudyTracker()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.activity_study_tracker, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val data: ArrayList<Pair<String, String>> = arrayListOf(
                Pair("Physics", "1:30:45"),
                Pair("Intro to SWE", "1:30:45"),
                Pair("User Centered Design", "1:30:45")
        )

        timers_recycler.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = StudyTrackerRecycleAdapter(data)
        }
    }
}
