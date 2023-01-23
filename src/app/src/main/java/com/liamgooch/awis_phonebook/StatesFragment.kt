package com.liamgooch.awis_phonebook

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.json.JSONArray
import org.json.JSONObject

class StatesFragment : Fragment(R.layout.state_fragment) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val s: String = getPhoneBook();
        val phoneBook : JSONObject = convertStringToJson(s);

        val states : ArrayList<String> = ArrayList()
        for(k in phoneBook.keys()){
            states.add(k)
        }
        states.sort()

        setOnClickListeners(phoneBook);

    }

    fun getPhoneBook() : String{
        return activity?.assets?.open(getString(R.string.preference_phonebook_key))?.bufferedReader()
            .use { it!!.readText()};
    }

    fun convertStringToJson(s: String) : JSONObject {
        val jsonArray = JSONArray(s);
        var jsonObject = JSONObject();


        for (i in 0 until jsonArray.length()){
            var state : String = JSONObject(jsonArray.getString(i)).get("State").toString();
            var item = JSONObject(jsonArray.getString(i));

            jsonObject.accumulate(state, item)
        }
        return jsonObject;
    }

    fun setOnClickListeners(phoneBook : JSONObject){
        activity?.findViewById<TextView>(R.id.state_nsw_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("NSW").toString())
        }
        activity?.findViewById<TextView>(R.id.state_nt_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("NT").toString())
        }
        activity?.findViewById<TextView>(R.id.state_qld_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("QLD").toString())
        }
        activity?.findViewById<TextView>(R.id.state_sa_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("SA").toString())
        }
        activity?.findViewById<TextView>(R.id.state_tas_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("TAS").toString())
        }
        activity?.findViewById<TextView>(R.id.state_vic_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("VIC").toString())
        }
        activity?.findViewById<TextView>(R.id.state_wa_textview)?.setOnClickListener{
            newPhoneFragment(phoneBook.get("WA").toString())
        }

    }

    fun newPhoneFragment(state : String){
        val phoneFragment = PhoneFragment.newInstance(state)
        parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragView, phoneFragment).commit()
    }
}