package com.androiddevnotes.lee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)

        fun someFunction(someCallback: SomeCallback) {
            val word = "nice"
            val letter = "12345"

            if (word.contains(letter)) {
                someCallback.onSuccess()
            } else {
                someCallback.onFailure("$word does not contain $letter")
            }
        }


        textView.setOnClickListener {
            someFunction(object : SomeCallback {
                override fun onSuccess() {
                    Toast.makeText(this@MainActivity, "Inside Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(error: String) {
                    Toast.makeText(this@MainActivity, "Inside Failure - $error", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        }

    }
}

interface SomeCallback {
    fun onSuccess()

    fun onFailure(error: String)
}