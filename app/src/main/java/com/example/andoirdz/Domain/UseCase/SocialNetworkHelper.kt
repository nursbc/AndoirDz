package com.example.andoirdz.Domain.UseCase

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.andoirdz.Domain.Contract.ISocialNetworkHelper

class SocialNetworkHelper(var context: Context): ISocialNetworkHelper {
    override fun initiateSendText(`package`: String, text: String) {
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.type = "text/plain"
        intent.`package` = `package`
        try {
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(context, "$`package`` Watsapp is not installed...", Toast.LENGTH_SHORT).show()
        }

    }

}