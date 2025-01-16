package edu.msudenver.cs3013.project2_s24

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

//Fragment that displays the home screen of the Colorado STEM Ecosystem app.
class home_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_, container, false)
        //set up and find the login button in the layout
        val loginButton: Button = view.findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            //navigate to the login activity when the login button is clicked
            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
        }
        return view
    }
}