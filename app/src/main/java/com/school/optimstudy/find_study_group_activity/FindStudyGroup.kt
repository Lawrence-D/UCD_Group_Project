package com.school.optimstudy.find_study_group_activity

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.optimstudy.R
import kotlinx.android.synthetic.main.activity_find_study_group.*
import kotlinx.android.synthetic.main.activity_main.*

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
                //Make some mock results
                if (study_group_search_field.text == null || study_group_uni_field.text == null
                    || study_group_duration_field.text == null || study_group_location_field.text == null
                    || study_group_prof_field.text == null || study_group_size_field.text == null) {
                    Snackbar.make(container, R.string.search_error_empty, Snackbar.LENGTH_SHORT).show()
                }

                var uni = "Kennesaw State University"
                var duration = "1hr"
                var location = "the Student Center"
                var clazz = "User Centered Design"
                var professor = "Jones"
                var size = "35"

                if (study_group_uni_field.text.toString() != "") {uni = study_group_uni_field.text.toString()}
                if (study_group_duration_field.text.toString() != "") {duration = study_group_duration_field.text.toString()}
                if (study_group_location_field.text.toString() != "") {location = study_group_location_field.text.toString()}
                if (study_group_prof_field.text.toString() != "") {professor = study_group_prof_field.text.toString()}
                if (study_group_size_field.text.toString() != "") {size = study_group_size_field.text.toString()}
                if (study_group_search_field.text.toString() != "") {clazz = study_group_search_field.text.toString()}

                val placeholderDescription = "This group is located at $uni.\nTheir meetings last for $duration, \n" +
                        "and are held at $location. The group is for $clazz taught by professor $professor, and has \n" +
                        "$size members."

                val results: Array<Pair<String, String>> = arrayOf(
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription),
                        Pair(study_group_search_field.text.toString(), placeholderDescription)
                )

                //Set the recyclerview's adapter
                search_result_list.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = SearchResultsRecyclerAdapter(results, arrayListOf(uni, duration,
                            location, clazz, professor, size))
                }
                return@OnKeyListener true
            }
            false
        })

        //Listen for click events on the search icon for refined search options
        search_button.setOnClickListener {
            //Show views that are hidden and also pray a little bc this might not work
            //UPDATE: It works
            when (refined_search_items.visibility) {
                View.VISIBLE -> {
                    refined_search_items.visibility = View.GONE
                    search_button.setImageDrawable(context.resources
                            .getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp))
                }
                View.GONE -> {
                    refined_search_items.visibility = View.VISIBLE
                    search_button.setImageDrawable(context.resources
                            .getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp))
                }
            }
        }
    }
}
