package com.school.optimstudy.find_study_group_activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.optimstudy.R
import kotlinx.android.synthetic.main.group_view.*

/**
 * Created by joe on 4/28/18.
 */

class GroupView : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.group_view, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val details = arguments.getStringArrayList("groupVals")
        group_view_location.text = "University: ${details[0]}"
        group_view_name.text = "Duration: ${details[1]}"
        group_view_subject.text = "Location: ${details[2]}"
        group_view_time.text = "Subject: ${details[3]}"
        group_view_description.text = "Professor: ${details[4]}"
        group_view_back.setOnClickListener {
            this.fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, FindStudyGroup.newInstance())
                    .commit()
        }
    }

}