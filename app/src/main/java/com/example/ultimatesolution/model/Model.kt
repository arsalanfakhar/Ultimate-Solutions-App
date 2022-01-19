package com.example.ultimatesolution.model


import androidx.room.PrimaryKey
import com.example.ultimatesolution.R

data class Task(
    var task_id: Int,
    var task_name: String,
    var task_img: Int
){
    override fun toString(): String {
        return task_name
    }
}

val taskList = arrayListOf(
    Task(0, "Cleaning", R.drawable.ic_cleaning_lady),
    Task(1, "Ac Service", R.drawable.ic_air_conditioner),
    Task(2, "Electrician", R.drawable.ic_electrician),
    Task(3, "Plumber", R.drawable.ic_plumber),
    Task(4, "Carpenter", R.drawable.ic_carpenter),
    Task(5, "Painter", R.drawable.ic_painter),
    Task(6, "Software Developer", R.drawable.ic_programmer),
    Task(7, "Tailor", R.drawable.ic_tailor),
    Task(8, "Labor", R.drawable.ic_worker),
    Task(9, "Moving", R.drawable.ic_moving),
    Task(10, "Event Planner", R.drawable.ic_event_planner),
    Task(11, "Graphic Designer", R.drawable.ic_graphic_designer),
    Task(12, "Gardener", R.drawable.ic_gardener),
    Task(12, "Photographer", R.drawable.ic_photo),
    Task(12, "Welder", R.drawable.ic_welder),
    )

