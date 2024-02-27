package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fragments.fragments.fragment1
import com.example.fragments.fragments.fragment2

class MainActivity : AppCompatActivity(), Comm1 {
    lateinit var button1: Button
    lateinit var button2: Button

    lateinit var fragment1: fragment1
    lateinit var fragment2: fragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        fragment1 = fragment1()
        fragment2 = fragment2()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment1)
            commit()
        }

        button1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment1)
                addToBackStack(null)
                commit()
            }
        }

        button2.setOnClickListener {
            val editTextPassing = findViewById<EditText>(R.id.editTextPassing)
            fragment2.arguments = passingData(editTextPassing.text.toString())

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment2)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun passingData(PassingText: String): Bundle {
        val bundle = Bundle()
        bundle.putString("txtAtoB", PassingText)

        return bundle
    }
}