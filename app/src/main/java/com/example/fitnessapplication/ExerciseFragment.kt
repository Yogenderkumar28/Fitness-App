package com.example.fitnessapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.fitnessapplication.databinding.FragmentExerciseBinding


class ExerciseFragment : Fragment() {

    data class Exercise(
        val exerciseType: String,
        val exerciseCount: Int
    )

    private val exercises : MutableList<Exercise> = mutableListOf(
        Exercise(exerciseType = "gifone", exerciseCount = 8),
        Exercise(exerciseType = "giftwo", exerciseCount = 5),
        Exercise(exerciseType = "gifthree", exerciseCount = 10),
        Exercise(exerciseType = "giffour", exerciseCount = 15),
        Exercise(exerciseType = "giffive", exerciseCount = 20)
    )

    lateinit var nextBtn: Button
    lateinit var exitBtn: Button
    lateinit var imageView: ImageView
    lateinit var txtView: TextView

    private lateinit var currentExercise: Exercise
    private var count: Int = 0
    private var exerciseIndex: Int = 0
    private var exerciseSize = Math.min((exercises.size+1)/2, 3)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_exercise, container, false)
        nextBtn = v.findViewById(R.id.next_btn)
        exitBtn = v.findViewById(R.id.exit_btn)
        imageView = v.findViewById(R.id.exercise_image_view)
        txtView = v.findViewById(R.id.exercise_text_view)

        randomiseExercises()
        nextBtn.setOnClickListener() {
            exerciseIndex++
            if(exerciseIndex < exerciseSize) {
                currentExercise = exercises[exerciseIndex]
                setExercise()
            }
        }
        return v
    }
    private fun randomiseExercises() {
        exercises.shuffle()
        exerciseIndex = 0
        setExercise()
    }

    private fun setExercise() {
        currentExercise = exercises[exerciseIndex]
        count = currentExercise.exerciseCount
        txtView.text = String.format(getString(R.string.exercise_text_view), count)
        imageView.setImageResource(resources.getIdentifier(currentExercise.exerciseType, "drawable", (activity as AppCompatActivity).packageName))
        (activity as AppCompatActivity).supportActionBar?.title = String.format(getString(R.string.title_android_fitness_exercise), exerciseIndex + 1, exerciseSize)
    }

}