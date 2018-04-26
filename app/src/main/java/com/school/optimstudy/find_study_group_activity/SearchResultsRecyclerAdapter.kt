package com.school.optimstudy.find_study_group_activity

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.optimstudy.R
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
    }

    override fun getItemCount() = data.size
}