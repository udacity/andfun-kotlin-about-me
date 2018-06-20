package com.example.android.aboutme

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.android.aboutme.databinding.ActivityMainBinding

/**
 * Main Activity of the AboutMe app. This app demonstrates:
 *     * LinearLayout with TextViews, ImageView, Button, EditText, and ScrollView
 *     * ScrollView to display scrollable text
 *     * Getting user input with an EditText.
 *     * Click handler for a Button to retrieve text from an EditText and set it in a TextView.
 *     * Setting the visibility status of a view.
 *     * Data binding between MainActivity and activity_main.xml. How to remove findViewById,
 *       and how to display data in views using the data binding object.
 */
class MainActivity : AppCompatActivity() {

    // Binding object for MainActivity.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: ActivityMainBinding

    // Instance of MyName data class.
    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting the content view using DataBindingUtil creates an instance of
        // ActivityMainBinding from the supplied activity and the supplied layout. This object
        // contains mappings between the activity and layout,
        // and functionality to interact with them.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Set the value of the myName variable that is declared and used in the layout file.
        binding.myName = myName

        // Click listener for the Done button.
        binding.doneButton.setOnClickListener {
            editNickname()
        }
    }

    /**
     * Click handler for the Done button.
     * Demonstrates how data binding can be used to make code much more readable
     * by eliminating calls to findViewById and changing data in the binding object.
     */
    private fun editNickname() {
        // Set the text for nicknameText to the value in nicknameEdit.
        binding.myName?.nickname = binding.nicknameEdit.text.toString()
        // Invalidate all binding expressions and request a new rebind to refresh UI
        binding.invalidateAll()
        // Change which views are visible.
        // Remove the EditText and the Button.
        // With GONE they are invisible and do not occupy space.
        binding.nicknameEdit.visibility = View.GONE
        binding.doneButton.visibility = View.GONE

        // Make the TexView with the nickname visible.
        binding.nicknameText.visibility = View.VISIBLE
    }
}
