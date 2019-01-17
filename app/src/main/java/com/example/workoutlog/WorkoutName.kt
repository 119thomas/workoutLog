package com.example.workoutlog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_workout_list.*

// import intent for our button
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class WorkoutName : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_list)

        workoutNameNextButton.setOnClickListener {
            val intent = Intent(this, ExcerciseList::class.java)
            intent.putExtra("workoutName", workoutName.text.toString())
            startActivity(intent)
        }
    }
}
