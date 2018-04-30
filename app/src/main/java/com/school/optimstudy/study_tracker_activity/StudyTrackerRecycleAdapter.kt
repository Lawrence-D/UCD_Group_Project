package com.school.optimstudy.study_tracker_activity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.optimstudy.R
import kotlinx.android.synthetic.main.study_tracker_item.view.*

/**
 * Created by joe on 4/29/18.
 */
class StudyTrackerRecycleAdapter(private val data: ArrayList<Pair<String, String>>):
        RecyclerView.Adapter<StudyTrackerRecycleAdapter.ViewHolder>() {
    class ViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.study_tracker_item, parent, false)

        return StudyTrackerRecycleAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.view.study_tracker_item_title.text = data[position].first
        holder.view.study_tracker_item_time.text = data[position].second
        holder.view.study_tracker_item_start.setOnClickListener {
            holder.view.study_tracker_item_stop.setOnClickListener {
                holder.view.study_tracker_item_time.text = "1:31:00"
            }
        }
    }

    override fun getItemCount(): Int = data.size
}