package com.example.aboutme

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Main Activity of the AboutMe app. This final app version demonstrates:
 *     * Using a LinearLayout with TextViews and EditText
 *     * Using a click handler with a button
 *     * Setting the visibility status of a view
 *     * Getting user input with an EditText and using the inputted value
 *     * Creating and using data biding to get rid of findViewById
 *     * Creating and using data binding to set the text of a text view
 */
class MainActivity : AppCompatActivity() {

    // Binding object for MainActivity.
    // Name of the object is derived from the name of the activity or fragment.
    private lateinit var binding: ActivityMainBinding

    // Instance of MyName. Since we are using it in multiple places, make it a member variable.
    private var newName: MyName = MyName()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting the content view using the DataBindingUtil creates an instance of
        // ActivityMainBinding from the supplied activity and the supplied layout. This object
        // contains mappings between the activity and layout, and some magic to interact with them.
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Create an instance of MyName and assign values.
        newName.name = "Borsov"
        // Give this a name that's clearly not what we want to end up with, so we can see how
        // it changes.
        newName.nickname = "placeholder" // Otherwise null and app crashes.
        // This sets the value of the aboutMe that is declared and used in the layout file.
        binding.aboutMe = newName

        // Just a plain old click listener like we set in the previous lesson.
        button_done.setOnClickListener {
            addNickname(it)
        }
    }

    /**
     * Click handler for the EditText.
     * Demonstrates how data binding can be used to make code much more readable
     * by eliminating calls to findViewById.
     */
    fun addNickname(view : View) {
        newName.nickname = binding.nicknameEdit.text.toString()

        // And we change which views are visible.
        // Remove the EditText and the Button. With GONE they are invisible and do not occupy space.
        binding.nicknameEdit.visibility = View.GONE
        binding.buttonDone.visibility = View. GONE
        // Since the button is passed in, we could reference it like this.
        // view.visibility = View.GONE
        // but it's more readable and consistent to use "binding." for all views.

        // Now make the text view with the nickname visible.
        binding.nickname.visibility = View.VISIBLE
    }
}