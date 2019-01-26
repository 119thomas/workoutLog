package com.example.workoutlog

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_workout_name.*

// import intent for our button
import android.content.Intent
import kotlinx.android.synthetic.main.activity_exercise_details.*

class WorkoutName : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_name)

        workoutNameNextButton.setOnClickListener {
            val intent = Intent(this, ExerciseList::class.java)
            intent.putExtra("workoutName", workoutName.text.toString())
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if(requestCode == WorkoutName.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("workoutName", workoutName.text)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
