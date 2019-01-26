package com.example.workoutlog

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

// import intent for our button
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /* companion methods are essentially static variables in kotlin */
    companion object {
        const val REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newWorkout.setOnClickListener{
            val intent = Intent(this, WorkoutName::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if(requestCode == MainActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {

        }
    }
}
