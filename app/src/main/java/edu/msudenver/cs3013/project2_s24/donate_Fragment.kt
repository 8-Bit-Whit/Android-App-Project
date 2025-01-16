package edu.msudenver.cs3013.project2_s24

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

//Fragment that displays information about donating to the Colorado STEM Ecosystem.
class donate_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_donate_, container, false)
        //set up and find the donate button in the layout
        val donateButton = view.findViewById<Button>(R.id.donate_button)
        //set an onclick listener for the donate button, links to website for donations
        donateButton.setOnClickListener {
            val url = "https://www.msudenver.edu/education/donate/colorado-stem-ecosystem/"
            //create an intent to open the url in a browser
            val intent = Intent(Intent.ACTION_VIEW)
            //parse the url and start the intent
            intent.data = Uri.parse(url)
            //start the intent
            startActivity(intent)
        }
        //set up and find the donate to about button in the layout
        val donateToAboutButton = view.findViewById<Button>(R.id.donate_to_about_button)
        donateToAboutButton.setOnClickListener {
            //navigate to the about ecosystem fragment when the button is clicked
            findNavController().navigate(R.id.action_nav_donate_to_nav_about_ecosystem)
        }

        return view
    }

}