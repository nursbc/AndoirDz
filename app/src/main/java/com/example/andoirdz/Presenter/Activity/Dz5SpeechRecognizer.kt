package com.example.andoirdz.Presenter.Activity

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.andoirdz.R
import java.util.*

class Dz5SpeechRecognizer : AppCompatActivity() {
    var recognizeButton: Button? = null
    var recognizedTextTextView: TextView? = null
    private val REQUEST_CODE_SPEECH_RECOGNIZER = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz6)

        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        recognizeButton = findViewById(R.id.activity_dz5_button_record)
        recognizedTextTextView = findViewById(R.id.activity_dz5_text_view_record_result)
    }

    fun initializeListeners() {
        recognizeButton?.setOnClickListener {
            startSpeechRecognize()
        }
    }

    private fun startSpeechRecognize() {
        val recognizeIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        try {
            startActivityForResult(recognizeIntent, REQUEST_CODE_SPEECH_RECOGNIZER)
        } catch(e: ActivityNotFoundException) {
            e.printStackTrace()
            Toast.makeText(this, "Ваше устройство не поддерживает разпознавание речи.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_CODE_SPEECH_RECOGNIZER -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    if (!result.isNullOrEmpty()) {
                        val recognizedText = result[0]
                        recognizedTextTextView?.setText(recognizedText)
                    }
                }
            }
        }
    }
}