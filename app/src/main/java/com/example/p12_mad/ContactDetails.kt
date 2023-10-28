package com.example.p12_mad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class ContactDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        //start
        val obj:MainActivity = MainActivity()
        obj.contacts().execute()
        //end

        val nameC=intent.getStringExtra("name")
        val numC=intent.getStringExtra("num")
        val addrC=intent.getStringExtra("addr")

        findViewById<TextView>(R.id.name_text).text=nameC
        findViewById<TextView>(R.id.num_text).text=numC
        findViewById<TextView>(R.id.addr_text).text=addrC
        findViewById<TextView>(R.id.logo_text).text= nameC?.get(0).toString()
    }
}