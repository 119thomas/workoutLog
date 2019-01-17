package com.example.workoutlog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_excercise_list.*
import kotlinx.android.synthetic.main.activity_workout_list.*

class ExcerciseList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excercise_list)

        val someValue = intent.getStringExtra("workoutName")
        workoutListName.text = someValue
    }
}
