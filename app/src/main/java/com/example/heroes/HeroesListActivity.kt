package com.example.heroes

import android.app.ActivityGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.heroes.databinding.ActivityHeroesListBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroesListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHeroesListBinding

    companion object {
        val TAG = "HeroesListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Make a hero.kit model class
        //TODO: Load the heroes.json into a List<Hero> using Gson
        val inputStream = resources.openRawResource(R.raw.heroes)
        val jsonString = inputStream.bufferedReader().use {
            it.readText()
        }
        val gson =  Gson()
        val type = object : TypeToken<List<Hero>>() { }.type
        val heroesList = gson.fromJson<List<Hero>>(jsonString, type)
        Log.d(TAG, "onCreat: \n$heroesList")
    }
}