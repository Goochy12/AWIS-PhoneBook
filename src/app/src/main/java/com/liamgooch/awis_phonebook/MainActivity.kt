package com.liamgooch.awis_phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import android.widget.SearchView
import androidx.fragment.app.add
import androidx.fragment.app.commit
import org.json.JSONArray
import org.json.JSONObject

private lateinit var searchBar: SearchView

class MainActivity : AppCompatActivity() {
//    fun getPhoneBook() : String{
//        return assets?.open(getString(R.string.preference_phonebook_key))?.bufferedReader()
//            .use { it!!.readText()};
//    }
//
//    fun newPhoneFragment(state : String){
//        val phoneFragment = PhoneFragment.newInstance(state)
//        supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragView, phoneFragment).commit()
//    }
//
//    fun convertStringToJson(s: String) : JSONObject {
//        val jsonArray = JSONArray(s);
//        var jsonObject = JSONObject();
//
//
//        for (i in 0 until jsonArray.length()){
//            var state : String = JSONObject(jsonArray.getString(i)).get("State").toString();
//            var item = JSONObject(jsonArray.getString(i));
//
//            jsonObject.accumulate(state, item)
//        }
//        return jsonObject;
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)

        if (savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<StatesFragment>(R.id.fragView)
            }
        }

//        val s: String = getPhoneBook();
//        val phoneBook : JSONObject = convertStringToJson(s);
//
//        val states : ArrayList<String> = ArrayList()
//        for(k in phoneBook.keys()){
//            states.add(k)
//        }
//        states.sort()
//
//        Log.i("JSON", phoneBook.toString())
//
//        searchBar = findViewById(R.id.search_bar)
//
//        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                return false
//            }
//        })

//        searchBar.setOnQueryTextListener(){
//            newPhoneFragment(phoneBook.get("NSW").toString())
//        }

    }


}