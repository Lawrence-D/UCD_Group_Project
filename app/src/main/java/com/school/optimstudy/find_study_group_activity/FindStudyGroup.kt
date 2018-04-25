package com.school.optimstudy.find_study_group_activity

import android.opengl.Visibility
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_find_study_group.*

import com.school.optimstudy.R

class FindStudyGroup : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.activity_find_study_group, container, false)
    }

    companion object {
        fun newInstance(): FindStudyGroup {
            return FindStudyGroup()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        //Attach an OnKeyListener to the keyboard enter button
        study_group_search_field.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_ENTER) {
                Toast.makeText(this.context,
                        study_group_search_field.text.toString(),
                        Toast.LENGTH_SHORT).show()
                return@OnKeyListener true
            }
            false
        })

        //Listen for click events on the search icon for refined search options
        search_button.setOnClickListener {
            //Show views that are hidden and also pray a little bc this might not work
            //UPDATE: It works
            when (refined_search_items.visibility) {
                View.VISIBLE -> refined_search_items.visibility = View.GONE
                View.GONE -> refined_search_items.visibility = View.VISIBLE
            }
        }
    }
}
