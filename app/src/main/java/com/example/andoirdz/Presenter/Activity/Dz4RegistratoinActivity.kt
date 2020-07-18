package com.example.andoirdz.Presenter.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.dz4_activity_regestration.*

class Dz4RegistratoinActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dz4_activity_regestration)

        initializeListener()
    }

    fun initializeListener() {
        dz4_activity_registration_button_send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.dz4_activity_registration_button_send -> {
                if (activity_registration_edit_text_login!!.text.isNotEmpty() && activity_registration_edit_text_password!!.text.isNotEmpty()) {
                    sendMessageWhatsApp("User:${activity_registration_edit_text_login?.text} password:${activity_registration_edit_text_password?.text}")
                }
            }
        }
    }

    fun sendMessageWhatsApp(message:String){
        val sendIntent = Intent()
        sendIntent.action = Intent.ACTION_SEND
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.type = "text/plain"
        sendIntent.setPackage("com.whatsapp")
        startActivity(sendIntent)
    }
}