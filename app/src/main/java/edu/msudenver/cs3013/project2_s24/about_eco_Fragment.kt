package edu.msudenver.cs3013.project2_s24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

//* Fragment that displays information about the ecosystem.
//* This fragment is part of the Colorado STEM Ecosystem app and provides
//* buttons for navigating to the Join and Mission sections.
class about_eco_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_eco, container, false)
        // Set up the Join button
        val aboutEcoJoinButton = view.findViewById<Button>(R.id.about_eco_join_button)
        // Navigate to the join fragment when the button is clicked
        aboutEcoJoinButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_about_ecosystem_to_nav_Join)
        }
        // Set up the Mission button
        val aboutEcoMissionButton = view.findViewById<Button>(R.id.about_eco_mission_button)
        //Navigate to the Mission fragment when the Mission button is clicked
        aboutEcoMissionButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_about_ecosystem_to_nav_mission)
        }

        return view
    }
}