package com.app.bushehrshoo.bushehrshoo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.google.i18n.phonenumbers.*;
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            val phoneNumber  = txtPhone_number.text.toString()
            if (phoneNumber.isNullOrBlank() || phoneNumber.isNullOrEmpty())
            {
                Toast.makeText(this , "Your Phone Number is not correct",Toast.LENGTH_LONG).show();
            }
            else
            {
                val phoneUtil = PhoneNumberUtil.getInstance()
                try {
                    val swissNumberProto = phoneUtil.parse(phoneNumber, "IR")

                    Toast.makeText(this , phoneUtil.isValidNumber(swissNumberProto).toString(),Toast.LENGTH_LONG).show();
                } catch (e: NumberParseException) {
                    Toast.makeText(this , "Error",Toast.LENGTH_LONG).show();
                }

            }

        }
    }
}
