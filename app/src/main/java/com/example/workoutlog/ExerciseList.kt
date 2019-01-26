package com.example.workoutlog

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_exercise_list.*

class ExerciseList : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_list)

        val someValue = intent.getStringExtra("workoutName")
        workoutNameCell.text = someValue

        /* get user information for a specified exercise */
        addExercise.setOnClickListener {
            val intent = Intent(this, ExerciseDetails::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        addWorkout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            setResult(Activity.RESULT_OK, intent)
            // intent.extra here
            finish()
        }
    }

    /* override the onActivityResult method so we can retrieve information from
       our exercise details Activity; exercise name, reps, sets.
       This method will be called when our ExerciseDetails activity returns */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {

        /* if our request code matches the one returned and the activity was successful,
           we will then add a new exercise to our layout; i.e. our workout */
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val name: String = data.getStringExtra("exerciseNameText")
            val sets: String = data.getStringExtra("setsText")
            val reps: String = data.getStringExtra("repsText")

            val newTextViewA = TextView(this)
            newTextViewA.textSize = 18f
            newTextViewA.text = "$name"
            workoutLayout.addView(newTextViewA)

            val newTextViewB = TextView(this)
            newTextViewB.textSize = 12f
            newTextViewB.text = "$sets x $reps\n"
            workoutLayout.addView((newTextViewB))
        }
    }
}
