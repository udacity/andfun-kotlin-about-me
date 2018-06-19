package com.example.aboutme

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
        binding.nickname.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        binding.nickname.visibility = View.VISIBLE
    }
}