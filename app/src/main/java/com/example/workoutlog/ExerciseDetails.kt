package com.example.workoutlog

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_exercise_details.*

class ExerciseDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_details)

        /* send back the name, set and reps to the exercise list for storing */
        addExerciseButton.setOnClickListener {
            val intent = Intent(this, ExerciseList::class.java)
            intent.putExtra("exerciseNameText", exerciseNameText.text.toString())
            intent.putExtra("repsText", repsText.text.toString().toInt())
            intent.putExtra("setsText", setsText.text.toString().toInt())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}