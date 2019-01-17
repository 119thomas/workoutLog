package com.example.workoutlog

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

// import intent for our button
import android.content.Intent

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_workout_list.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  we create an on click listener that will launch our
            workout details activity */
        addWorkout.setOnClickListener{
            val intent = Intent(this, WorkoutName::class.java)
            startActivity(intent)
        }
    }
}
