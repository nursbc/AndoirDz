package com.example.andoirdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val name = "icarus"
    val password = "fallen"
    val showtext = "It's so sad =("

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeListeners()
    }

    fun initializeListeners()
    {
        button_mainaactivity_visibilitybutton.setOnClickListener(this)
        button_mainaactivity_CheckFields.setOnClickListener(this)
        edittext_mainactivity_name.setOnClickListener(this)
        edittext_mainactivity_password.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_mainaactivity_visibilitybutton -> {
                if(textview_mainactivity_showtext.visibility == TextView.VISIBLE && edittext_mainactivity_name.visibility == EditText.VISIBLE && edittext_mainactivity_password.visibility == EditText.VISIBLE && button_mainaactivity_CheckFields.visibility == Button.VISIBLE) {
                    textview_mainactivity_showtext.visibility = TextView.INVISIBLE
                    edittext_mainactivity_name.visibility = EditText.INVISIBLE
                    edittext_mainactivity_password.visibility = EditText.INVISIBLE
                    button_mainaactivity_CheckFields.visibility = Button.INVISIBLE
                }
                else
                {
                    textview_mainactivity_showtext.visibility = TextView.VISIBLE
                    edittext_mainactivity_name.visibility = EditText.VISIBLE
                    edittext_mainactivity_password.visibility = EditText.VISIBLE
                    button_mainaactivity_CheckFields.visibility = Button.VISIBLE
                }
            }
            R.id.button_mainaactivity_CheckFields -> {
                when {
                    edittext_mainactivity_name.text.toString().isEmpty() -> {
                        edittext_mainactivity_name.setText("Write Name")
                    }
                    edittext_mainactivity_password.text.toString().isEmpty() -> {
                        edittext_mainactivity_password.setText("Write Password")
                    }
                }
                if(edittext_mainactivity_name.text.toString() == name && edittext_mainactivity_password.text.toString() == password)
                {
                    textview_mainactivity_showtext.setText(showtext)
                }
                else
                    textview_mainactivity_showtext.setText("Wrong name or password")
            }
            R.id.edittext_mainactivity_name -> {
                if(edittext_mainactivity_name.hasFocus() == true)
                {
                    edittext_mainactivity_name.setText("")
                }
            }
            R.id.edittext_mainactivity_password -> {
                if(edittext_mainactivity_password.hasFocus() == true)
                {
                    edittext_mainactivity_password.setText("")
                }
            }
        }

    }
}