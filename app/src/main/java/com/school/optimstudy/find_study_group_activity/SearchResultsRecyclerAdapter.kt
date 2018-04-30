package com.school.optimstudy.find_study_group_activity

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.SupportActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.optimstudy.R
import com.school.optimstudy.create_study_group.Create_Study_Group_Congratulations
import kotlinx.android.synthetic.main.find_study_group_result.view.*

class SearchResultsRecyclerAdapter(private val data: Array<Pair<String, String>>, val details: ArrayList<String>) :
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
            val act = holder.view.context as AppCompatActivity
            val groupview = GroupView()
            val args = Bundle()
            args.putStringArrayList("groupVals", details)
            groupview.arguments = args
            act.supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, groupview)
                    .commit()
        }
    }

    override fun getItemCount() = data.size
}