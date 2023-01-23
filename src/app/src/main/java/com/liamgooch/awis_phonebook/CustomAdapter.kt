package com.liamgooch.awis_phonebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject


class CustomAdapter(private val dataSet: JSONArray, private val listener: (phonenumber: String) -> Unit) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    public var ph: String? = null

    class ViewHolder(view: View, private val listener: (phonenumber: String) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val airportTextView: TextView
        val phoneTextView: TextView

        init {
            airportTextView = view.findViewById(R.id.airportTextView)
            phoneTextView = view.findViewById(R.id.phoneTextView)

            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            listener(phoneTextView.text.toString())
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.phone_row_item, viewGroup, false)

        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.airportTextView.text = JSONObject(dataSet.getString(position)).getString("Airport")
        ph = JSONObject(dataSet.getString(position)).getString("Phone")
        viewHolder.phoneTextView.text = ph

    }

    override fun getItemCount() = dataSet.length()
}