package com.school.optimstudy.find_study_group_activity

import android.app.Activity
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.optimstudy.R
import com.school.optimstudy.create_study_group.Create_Study_Group_Congratulations
import kotlinx.android.synthetic.main.find_study_group_result.view.*

class SearchResultsRecyclerAdapter(private val data: Array<Pair<String, String>>) :
        RecyclerView.Adapter<SearchResultsRecyclerAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context)
                .inflate(R.layout.find_study_group_result, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.view.search_result_title.text = data[position].first
        holder.view.search_result_description.text = data[position].second
        holder.view.search_result_image.setBackgroundColor(Color.BLUE)
        holder.view.result_bg.setOnClickListener {
            val act = holder.view.context as Activity
            act.fragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, )
                    .commit()
        }
    }

    override fun getItemCount() = data.size
}