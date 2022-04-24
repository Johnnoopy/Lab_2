package com.example.lab_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class Activity_page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)
        val edit_drink = findViewById<EditText>(R.id.edit_drink)
        val group_sugar = findViewById<RadioGroup>(R.id.group_sugar)
        val group_ice = findViewById<RadioGroup>(R.id.group_ice)
        val order = findViewById<Button>(R.id.order)
        order.setOnClickListener(){
            if(edit_drink.length() == 0 || edit_drink.length() < -1 ){
                Toast.makeText(this@Activity_page2,"請輸入飲料名稱",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                val sugarid = group_sugar.checkedRadioButtonId
                val iceid = group_ice.checkedRadioButtonId
                //  兩個group如果都沒有勾選的那預設值會是  -1
                if(sugarid.toString() == "-1" || iceid.toString() == "-1"){
                    Toast.makeText(this,"請輸入甜度冰塊",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }else{
                    val bundle = Bundle()
                    bundle.putString("sugar",group_sugar.findViewById<RadioButton>(group_sugar.checkedRadioButtonId).text.toString())
                    bundle.putString("ice",group_ice.findViewById<RadioButton>(group_ice.checkedRadioButtonId).text.toString())
                    bundle.putString("drink",edit_drink.text.toString())
                    val intent2 = Intent(this,MainActivity::class.java)
                   // intent2.putExtras(bundle)
                    setResult(Activity.RESULT_OK, Intent().putExtras(bundle))
                    finish()
                }
            }
        }

    }
}