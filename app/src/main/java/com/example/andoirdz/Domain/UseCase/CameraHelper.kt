package com.example.andoirdz.Domain.UseCase

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.example.andoirdz.Domain.Contract.ICameraHelper

class CameraHelper(var contextActivity: Activity, var requestCode: Int): ICameraHelper {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun initiateStartCamera() {
        if(contextActivity.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            contextActivity.startActivityForResult(cameraIntent, requestCode)
        } else {
            contextActivity.requestPermissions(Array<String>(1){android.Manifest.permission.CAMERA}, 101)
        }
    }
}