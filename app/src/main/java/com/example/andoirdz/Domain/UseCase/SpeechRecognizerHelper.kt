package com.example.andoirdz.Domain.UseCase

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Build
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.andoirdz.Domain.Contract.ISpeechRecognizerHelper
import java.util.*

class SpeechRecognizerHelper(var contextActivity: Activity, var requestCode: Int): ISpeechRecognizerHelper {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initiateStartSpeechRecognize() {
        val recognizeIntent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        recognizeIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
        try {
            contextActivity.startActivityForResult(recognizeIntent, requestCode)
        } catch(e: ActivityNotFoundException) {
            e.printStackTrace()
            Toast.makeText(contextActivity, "Your device does not support speech recognition.", Toast.LENGTH_SHORT).show()
        }

    }
}