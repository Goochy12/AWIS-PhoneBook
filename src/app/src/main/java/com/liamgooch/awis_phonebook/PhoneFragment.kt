package com.liamgooch.awis_phonebook

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray


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
        val adapter = CustomAdapter(airportsJsonArray){ph -> onClickCallback(ph)};
        rV.adapter = adapter;
        rV.layoutManager = LinearLayoutManager(activity);


    }

    fun onClickCallback(ph: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$ph"))
        startActivity(intent)
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
