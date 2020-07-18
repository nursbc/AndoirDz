package com.example.andoirdz.Presenter.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.dz4_activity.*

class Dz4Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dz4_activity)

        initializeListeners()
    }

    fun initializeListeners()
    {
        dz4_activity_main_button_send_message_whatsapp.setOnClickListener(this)
        dz4_activity_main_button_registration.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.dz4_activity_main_button_send_message_whatsapp -> {
                sendMessageWhatsAppFriend("+77072008993", "???")
            }
            R.id.dz4_activity_main_button_registration -> {
                val intent = Intent(this, Dz4RegistratoinActivity::class.java)
                startActivity(intent)
            }
        }

    }

    fun sendMessageWhatsAppFriend(number: String, message:String){
        val friendnumber = number
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"
        sendIntent.putExtra(Intent.EXTRA_TEXT, message)
        sendIntent.putExtra("jid", "$friendnumber@s.whatsapp.net")
        sendIntent.setPackage("com.whatsapp")
        startActivity(sendIntent)
    }
}