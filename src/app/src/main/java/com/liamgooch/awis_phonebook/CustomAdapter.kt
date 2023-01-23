package com.liamgooch.awis_phonebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.AlignSelf
import com.google.android.flexbox.FlexboxLayoutManager
import org.json.JSONArray
import org.json.JSONObject


class CustomAdapter(private val dataSet: JSONArray) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val airportTextView: TextView
        val phoneTextView: TextView

        init {
            airportTextView = view.findViewById(R.id.airportTextView)
            phoneTextView = view.findViewById(R.id.phoneTextView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.phone_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.airportTextView.text = JSONObject(dataSet.getString(position)).getString("Airport")
        viewHolder.phoneTextView.text = JSONObject(dataSet.getString(position)).getString("Phone")
    }

    override fun getItemCount() = dataSet.length()
}