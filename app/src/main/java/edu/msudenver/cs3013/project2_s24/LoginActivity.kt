package edu.msudenver.cs3013.project2_s24

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Activity that allows the user to login to the Colorado STEM Ecosystem app.
class LoginActivity : AppCompatActivity() {
    //initialize the variables for the username, password, submit login button, back button, and main layout
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginSubmitButton: Button
    private lateinit var backHomeFragmentButton: ImageButton
    private lateinit var mainLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //set the username and password edit text to be focused
        usernameEditText = findViewById(R.id.login_enter_username)
        passwordEditText = findViewById(R.id.login_enter_password)
        //set the submit login button and back button to be focused
        loginSubmitButton = findViewById(R.id.login_submit_button)
        backHomeFragmentButton = findViewById(R.id.back_home_fragment_button)
        mainLayout = findViewById(R.id.main)

        loginSubmitButton.setOnClickListener {
            //get the username and password from the edit text fields
            hideKeyboard() //hide the keyboard
            val username = usernameEditText.text.toString() //get the username
            val password = passwordEditText.text.toString() //get the password
            //check if the username or password is empty, if it is show error message
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this,
                    "Username or Password is empty. Both fields must be filled.",
                    Toast.LENGTH_SHORT
                ).show()
                //check if the username and password are valid, if they are navigate to the welcome activity
            } else if (isValidCredentials(username, password)) {
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
                finish()
                //if the username or password is invalid, show an error message
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
        //set an onclick listener for the back button, finish the activity
        backHomeFragmentButton.setOnClickListener {
            finish()
        }
        //set the main layout to be focused and hide the keyboard when the layout is touched outside of the edit text fields
        mainLayout.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                hideKeyboard()
            }
            false
        }
    }
    //function to check if the username and password are valid, user and password will only work at this time
    private fun isValidCredentials(username: String, password: String): Boolean {
        return username == "user" && password == "password"
    }
    //function to hide the keyboard
    private fun hideKeyboard() {
        //get the input method manager and hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        currentFocus?.let { view ->
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
    //function to hide the keyboard when the layout is touched
    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}