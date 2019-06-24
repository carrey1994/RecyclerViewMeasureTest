package com.example.kuanche.recyclerviewmeasuretest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v4.widget.NestedScrollView
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val manager = LinearLayoutManager(this@MainActivity)
        val movieList = listOf(
            Movie("Day1", "Friends", R.drawable.pixar_toy_story, true),
            Movie("Day2", "HIDE", R.drawable.pixar_toy_story_2),
            Movie("Day3", "Friends", R.drawable.pixar_bugslifeposter, true),
            Movie("Day4", "Friends", R.drawable.pixar_monsters, true),
            Movie("Day5", "Family", R.drawable.pixar_nemo, true),
            Movie("Day6", "Enviroment", R.drawable.pixar_wall_e),
            Movie("Day7", "Family", R.drawable.pixar_incredibles),
            Movie("Day8", "Friends", R.drawable.pixar_ratatouille),
            Movie("Day9", "Family", R.drawable.pixar_up),
            Movie("Day10", "Friends", R.drawable.pixar_cars),
            Movie("Day11", "Friends", R.drawable.pixar_coco)
        )
        

        val adapter = MainAdapter(this@MainActivity, movieList)
        rv_main.layoutManager = manager
        rv_main.adapter = adapter
    }
}
