package com.liamgooch.awis_phonebook

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import org.json.JSONArray
import org.json.JSONObject


class RecycFragment : Fragment(R.layout.recyc_frag) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val s: String = getPhoneBook();
        val phoneBook : JSONObject = convertStringToJson(s);

        val states : ArrayList<String> = ArrayList()
        for(k in phoneBook.keys()){
            states.add(k)
        }

        val rV = activity?.findViewById<View>(R.id.rV) as RecyclerView
        val adapter = CustomAdapter(states);
        rV.adapter = adapter;
        rV.layoutManager = LinearLayoutManager(activity);

//        val layoutManager = FlexboxLayoutManager(activity)
//        layoutManager.flexDirection = FlexDirection.COLUMN
//        layoutManager.justifyContent = JustifyContent.FLEX_END
//        layoutManager.flexWrap = FlexWrap.WRAP
//
//        rV.layoutManager = layoutManager
    }


    fun getPhoneBook() : String{
        return activity?.assets?.open(getString(R.string.preference_phonebook_key))?.bufferedReader()
            .use { it!!.readText()};
    }

    fun convertStringToJson(s: String) : JSONObject {
        val jsonArray: JSONArray = JSONArray(s);
        var jsonObject: JSONObject = JSONObject();


        for (i in 0 until jsonArray.length()){
            var state : String = JSONObject(jsonArray.getString(i)).get("State").toString();
            var item = JSONObject(jsonArray.getString(i));

            jsonObject.accumulate(state, item)
        }
        return jsonObject;
    }
}