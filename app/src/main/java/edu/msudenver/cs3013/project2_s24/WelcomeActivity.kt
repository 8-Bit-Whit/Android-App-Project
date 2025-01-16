package edu.msudenver.cs3013.project2_s24

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Activity that displays a welcome message to the user after they have successfully logged in.
// Uses the username from the login activity to display a personalized welcome message.
class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        // gets the username from the login activity
        val username = intent.getStringExtra("USERNAME")
        // sets the welcome message to display the username
        val welcomeTextView: TextView = findViewById(R.id.welcome_message)
        // displays welcome message including the username
        welcomeTextView.text = "Welcome back $username!"
        //back to login button
        val backToLoginButton: ImageButton = findViewById(R.id.back_to_login_button)
        //back to home fragment button
        val backToHomeButton: ImageButton = findViewById(R.id.back_to_home_frag_button)
        //set on click listeners for the back to login activity button
        backToLoginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() //this closes the welcome activity
        }
        //set on click listeners for the back to home fragment button
        backToHomeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) //create an intent to start MainActivity
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK //add flags to clear the activity stack and start a new task.
            //this ensures that when we go back to the mainactivity it is treated as a new instance and any previous activities are cleared
            startActivity(intent)
            finish() //this closes the welcome activity
        }

    }
}