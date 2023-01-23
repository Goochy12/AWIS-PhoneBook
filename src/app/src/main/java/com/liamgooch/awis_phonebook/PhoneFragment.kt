package com.liamgooch.awis_phonebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONObject


class PhoneFragment : Fragment(R.layout.phone_fragment) {

    private var phoneBookString: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            phoneBookString = it.getString("phonebook")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val airportsJsonArray : JSONArray = JSONArray(phoneBookString)
        //val airports: ArrayList<String> = ArrayList()


        val rV = activity?.findViewById<View>(R.id.rV) as RecyclerView
        val adapter = CustomAdapter(airportsJsonArray);
        rV.adapter = adapter;
        rV.layoutManager = LinearLayoutManager(activity);

//        val layoutManager = FlexboxLayoutManager(activity)
//        layoutManager.flexDirection = FlexDirection.COLUMN
//        layoutManager.justifyContent = JustifyContent.FLEX_END
//        layoutManager.flexWrap = FlexWrap.WRAP
//
//        rV.layoutManager = layoutManager
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.phone_fragment, container, false)
    }


    companion object {
        @JvmStatic
        fun newInstance(phonebookString: String) =
            PhoneFragment().apply {
                arguments = Bundle().apply {
                    putString("phonebook", phonebookString)
                }
            }
    }
}