package com.example.andoirdz.Presenter.Activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.andoirdz.R
import kotlinx.android.synthetic.main.activity_dz7_get_info_registration.*
import java.io.ByteArrayOutputStream
import java.io.IOException

class Dz7getRegistrarionInformation : AppCompatActivity(), View.OnClickListener {

    private var cameraStubBitmap: Bitmap? = null
    private val REQUEST_IMAGE_CAPTURED = 1

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dz7_get_info_registration)

        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        cameraStubBitmap = getBitmapFromAssets("camera_stub_image.png")
        if(cameraStubBitmap != null) {
            imageview_activity_user_registration_user_selfie?.setImageBitmap(cameraStubBitmap)
        }

    }
    fun initializeListeners() {
        imageview_activity_user_registration_user_selfie.setOnClickListener(this)
        button_activity_user_registration_fill_info.setOnClickListener(this)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.imageview_activity_user_registration_user_selfie -> {
                if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURED)
                } else {
                    requestPermissions(Array<String>(1){ android.Manifest.permission.CAMERA }, 101)
                }
            }
            R.id.button_activity_user_registration_fill_info -> {
                val bitmapDrawable = imageview_activity_user_registration_user_selfie?.drawable as BitmapDrawable
                val bitmap = bitmapDrawable.bitmap

                if(bitmap.sameAs(cameraStubBitmap)) {
                    Toast.makeText(this, "Невозможно заполнить данные\nИзображение не заполнено!", Toast.LENGTH_SHORT).show()
                }
                if(edittext_activity_user_registration_user_name?.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Невозможно заполнить данные\nИмя не заполнено!", Toast.LENGTH_SHORT).show()
                }
                if(edittext_activity_user_registration_user_surname?.text.isNullOrEmpty()) {
                    Toast.makeText(this, "Невозможно заполнить данные\nФамилия не заполнена!", Toast.LENGTH_SHORT).show()
                }

                val intent = Intent(this, Dz7showRegistrarionInformation::class.java)
                intent.putExtra("userSelfie", drawableToByteArray(imageview_activity_user_registration_user_selfie?.drawable as BitmapDrawable))
                intent.putExtra("userFirstName", edittext_activity_user_registration_user_name?.text.toString())
                intent.putExtra("userSurname", edittext_activity_user_registration_user_surname?.text.toString())
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            REQUEST_IMAGE_CAPTURED -> {
                if(resultCode == Activity.RESULT_OK) {
                    val imageBitmap = data?.extras?.get("data") as Bitmap
                    imageview_activity_user_registration_user_selfie?.setImageBitmap(imageBitmap)
                }
            }
        }
    }

    private fun getBitmapFromAssets(fileName: String): Bitmap? {
        return try {
            BitmapFactory.decodeStream(assets.open(fileName))
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    private fun drawableToByteArray(drawable: BitmapDrawable): ByteArray {
        val bitmap = drawable.bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }

}
