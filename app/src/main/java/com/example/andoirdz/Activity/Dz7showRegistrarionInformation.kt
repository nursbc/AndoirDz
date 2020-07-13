package com.example.andoirdz.Activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.activity_dz7_show_registration_info.*
import java.io.ByteArrayInputStream

class Dz7showRegistrarionInformation :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz7_show_registration_info)

        initializeViews()
    }

    fun initializeViews() {
        val userSelfieByteArray = intent?.extras?.getByteArray("userSelfie")
        val userFirstName = intent?.extras?.getString("userFirstName")
        val userSurname = intent?.extras?.getString("userSurname")

        if (userSelfieByteArray != null) {
            imageview_activity_registered_user_info_user_selfie?.setImageBitmap(byteArrayToBitmap(userSelfieByteArray))
        }
        if(userFirstName != null) {
            edittext_activity_registered_user_info_user_first_name?.setText(userFirstName)
        }
        if(userSurname != null) {
            edittext_activity_registered_user_info_user_surname?.setText(userSurname)
        }
    }

    private fun byteArrayToBitmap(byteArray: ByteArray): Bitmap {
        val `is` = ByteArrayInputStream(byteArray)
        return BitmapFactory.decodeStream(`is`)
    }
}