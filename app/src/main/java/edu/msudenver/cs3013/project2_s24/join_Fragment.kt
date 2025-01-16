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

class join_Fragment : Fragment() {
    //Fragment that displays information about joining the Colorado STEM Ecosystem.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_join_, container, false)
        // Set up membership form button
        val membershipFormButton = view.findViewById<Button>(R.id.membership_form_button)
        // Set an onclick listener for the membership form button, links to the online membership form
        membershipFormButton.setOnClickListener {
            val url = "https://docs.google.com/forms/d/e/1FAIpQLSeje1TJdAE-VP0jkZzYOJ72mcmQOQfMNliMJ5J8BUaookEnpA/viewform"
            // Create an intent to open the url in a browser
            val intent = Intent(Intent.ACTION_VIEW)
            // Parse the url and start the intent
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
        // Set up Join to contact button
        val joinToContactButton = view.findViewById<Button>(R.id.Join_to_contact_button)
        joinToContactButton.setOnClickListener {
            // Navigate to the contact fragment when the button is clicked
            findNavController().navigate(R.id.action_nav_Join_to_nav_contact)
        }

        return view
    }
}