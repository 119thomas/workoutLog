package com.example.workoutlog

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

// import intent for our button
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.workout_row.view.*
import android.util.Log
import android.view.TextureView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val workouts = ArrayList<Workout>()

    // companion methods are essentially static variables in Java
    companion object {
        const val REQUEST_CODE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when the new workout button is pressed, we will query for a workout name
        newWorkout.setOnClickListener{
            val intent = Intent(this, WorkoutName::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        // our recyclerView needs a layoutManager and adapter to function
        // layoutManager -> positions the item views inside the recyclerView
        // adapter -> creates the view holders as needed
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MainAdapter(workouts)
    }

    // once we have finished collecting the workout name and exercise details,
    // we will add them to our workouts list and update the recyclerView
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if(requestCode == MainActivity.REQUEST_CODE && resultCode == Activity.RESULT_OK) {

        }
    }
}

/**
 * manage the view holder objects and bind them to their data
 */
class MainAdapter(private val workouts: ArrayList<Workout>): RecyclerView.Adapter<MainAdapter.CustomViewHolder>() {

    // number of items in our recyclerView
    override fun getItemCount(): Int {
        return workouts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cell = layoutInflater.inflate(R.layout.workout_row, parent, false)
        return CustomViewHolder(cell)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val workoutNames = workouts[position]
        holder.view.workoutNameCell.text = workoutNames.getName()
    }

    /**
     * describes an item view and metadata about its place within the RecyclerView
     */
    class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }
    }
}

// a workout object is defined as having a name, amount of sets, and number of reps
class Workout(name: String, sets: Int, reps: Int) {
    private var name = ""
    private var sets = 0
    private var reps = 0

    init {
        this.name = name
        this.sets = sets
        this.reps = reps
    }

    fun getName(): String {
        return name
    }

    fun getSets(): Int {
        return sets
    }

    fun getReps(): Int {
        return reps
    }
}

