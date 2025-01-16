package edu.msudenver.cs3013.project2_s24

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

//Fragment that displays various links to outside resources for the Colorado STEM Ecosystem.
class resources_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resources_, container, false)

        // Resources map button
        val resourcesMapButton = view.findViewById<Button>(R.id.resources_map_button)
        resourcesMapButton.setOnClickListener {
            openUrl("https://embed.kumu.io/103c6075bc68ad6578a9b4dc7654e5b7#organization-stakeholder-map")
        }

        // Office of Education Solution button
        val officeEducationButton = view.findViewById<Button>(R.id.resources_office_education_solution_button)
        officeEducationButton.setOnClickListener {
            openUrl("https://www.msudenver.edu/education/office-of-education-solutions/")
        }

        // MSU School of Education button
        val msuSchoolButton = view.findViewById<Button>(R.id.MSU_school_of_education_button)
        msuSchoolButton.setOnClickListener {
            openUrl("https://www.msudenver.edu/education/")
        }

        // STEM Learning Ecosystems Practice button
        val stemEcosystemsButton = view.findViewById<Button>(R.id.STEM_learning_ecosystems_practice_button)
        stemEcosystemsButton.setOnClickListener {
            openUrl("https://stemecosystems.org/")
        }

        // First 90 Day Report button
        val firstReportButton = view.findViewById<Button>(R.id.First_90_day_report_button)
        firstReportButton.setOnClickListener {
            openUrl("https://www.msudenver.edu/wp-content/uploads/2022/06/CO-STEM-Ecosystem-First-90-Day-Report.pdf")
        }

        return view
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance() = resources_Fragment()
    }
}