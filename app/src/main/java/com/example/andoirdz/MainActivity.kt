package com.example.andoirdz

import android.content.res.ColorStateList
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.forEachIndexed
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val name = "icarus"
    val password = "fallen"
    val showtext = "It's so sad =("

    var products : ArrayList<String> = ArrayList()
    var linearLayoutProducts : LinearLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeData()
        initializeViews()
        initializeCheckBox()
        initializeListeners()
    }

    fun initializeData()
    {
        products = arrayListOf("Bread",
            "Honey",
            "Chocolate",
            "Apple",
            "Banana",
            "Nuts",
            "Cake",
            "Corn",
            "Meat",
            "Potato",
            "Mango",
            "Sausage",
            "Meal",
            "Apricot",
            "Pineapple")
    }

    fun initializeCheckBox()
    {
        (0 until 15).forEach {
            var p = products.shuffled().first()
            var checkBox = CheckBox(getApplicationContext())
            checkBox.setText(p)
            products.remove(p)
            linearLayoutProducts?.addView(checkBox)
        }
    }

    fun initializeViews()
    {
        linearLayoutProducts = findViewById(R.id.lainear_layout_main_activity_products)
    }

    fun initializeListeners()
    {
        button_mainaactivity_visibilitybutton.setOnClickListener(this)
        button_mainaactivity_CheckFields.setOnClickListener(this)
        edittext_mainactivity_name.setOnClickListener(this)
        edittext_mainactivity_password.setOnClickListener(this)
        button_main_activity_checkbox_button.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.M)
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
            R.id.button_main_activity_checkbox_button -> {
                linearLayoutProducts?.forEachIndexed { index, view ->
                    (view as CheckBox).setTextColor(getColorStateList(R.color.colorAccent))
                    if((view as CheckBox).isChecked == false)
                    {
                        (view as CheckBox).setTextColor(getColorStateList(R.color.Red))
                    }
                }
            }
        }

    }
}

