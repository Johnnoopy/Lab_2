package com.example.lab_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ){
            if(it.resultCode == Activity.RESULT_OK){
                val drink = it.data?.getStringExtra("drink")
                val ice = it.data?.getStringExtra("ice")
                val sugar = it.data?.getStringExtra(("sugar"))
                val text_drink = findViewById<TextView>(R.id.text_drink)
                val text_sugar = findViewById<TextView>(R.id.text_sugar)
                val text_ice = findViewById<TextView>(R.id.text_ice)
                text_drink.text = "飲料:$drink"
                text_sugar.text = "甜度:$sugar"
                text_ice.text = "冰塊:$ice"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val choice = findViewById<Button>(R.id.btn_choice)

        choice.setOnClickListener(){
            val intent = Intent(this,Activity_page2::class.java)
            getResult.launch(intent)
        }

    }
}