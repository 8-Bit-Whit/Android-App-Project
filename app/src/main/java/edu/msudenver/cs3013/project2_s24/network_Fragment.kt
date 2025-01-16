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

//Fragment that displays information about the visualization network of the Colorado STEM Ecosystem.
class network_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_network_, container, false)
        // Find the visualization map button
        val visualizationMapButton: Button = view.findViewById(R.id.visualization_map_button)

        // Set click listener for the visualization map button
        visualizationMapButton.setOnClickListener {
            // URL of the Kumu Visualization Map
            val url =
                "https://embed.kumu.io/103c6075bc68ad6578a9b4dc7654e5b7#organization-stakeholder-map"

            // Create an Intent to open the URL
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            // Start the activity to open the URL in a browser
            startActivity(intent)
        }

        // Set up network resources button
        val networkResourcesButton = view.findViewById<Button>(R.id.network_resources_button)
        networkResourcesButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_network_to_nav_resources)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = network_Fragment()
    }
}