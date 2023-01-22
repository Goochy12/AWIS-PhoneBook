package com.example.awis_phonebook

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val s: String = getPhoneBook();
        val phoneBook : JSONObject = convertStringToJson(s);
    }

    fun getPhoneBook() : String{
        return applicationContext.assets.open(getString(R.string.preference_phonebook_key)).bufferedReader().use {it.readText()};
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