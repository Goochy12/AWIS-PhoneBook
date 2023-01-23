package com.liamgooch.awis_phonebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.AlignSelf
import com.google.android.flexbox.FlexboxLayoutManager




class CustomAdapter(private val dataSet: ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.stateTextView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.state_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = dataSet[position]

//        val lp : ViewGroup.LayoutParams = viewHolder.textView.layoutParams
//        if (lp is FlexboxLayoutManager.LayoutParams){
//            val fp : FlexboxLayoutManager.LayoutParams = lp as FlexboxLayoutManager.LayoutParams
//            fp.flexGrow = 1.0f
//            fp.alignSelf = AlignItems.FLEX_END
//        }
    }

    override fun getItemCount() = dataSet.size
}